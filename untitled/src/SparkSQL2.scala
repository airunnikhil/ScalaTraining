import org.apache.spark.sql.{SparkSession, functions}

object SparkSQL2 {


  def main(args : Array[String]) = {

    val ss = SparkSession.builder()
      .appName("IBMJob8")
      .master("local[*]")
      .getOrCreate()


    //Schema Inferrencing i.e. Spark automatically based on comma, formatted data in table
    //Upto Spark2.3 - only .csv, .json, .parquet, .orc, .avro are supported
    val csvDF = ss.read
                      .option("header","true")
                      .csv("hdfs://localhost:9000/ibm/auth.csv/")

    csvDF.createOrReplaceTempView("AUTH_TABLE") // create table
    // csvDF.createOrReplaceGlobalTempView("AUTH_TABLE") // global temp view that can be shared across multiple session

    val allDf = ss.sql("SELECT * FROM AUTH_TABLE LIMIT 100") // get 10 rows only
    // val allDf = ss.sql("SELECT * FROM global_temp.AUTH_TABLE LIMIT 10")    // Access the global view

    //Another way to write Spark-SQL constructs
    //allDf.select("asa")
    allDf.select(allDf.col("asa").gt("1400"))

    // create UDF function to convert string to double
    val toDouble = functions.udf[Double, String](_.toDouble)

    //Another UDF function to validate some data
    val toDataValidation = functions.udf[Double,String]({ each =>
      if (each.equals("1400"))
        123d
      else 456d
    })

    //convert datatype of ver column to double. first @param takes the column to change
    val changedDF = allDf.withColumn("ver", toDouble(allDf.col("ver")))
    val modifiedDF = allDf.withColumn("asa", toDataValidation(allDf.col("asa")))

    modifiedDF.show()

    //Printing Schema i.e. Data Types of Inferrenced
    //csvDF.printSchema()

    //Displaying default 20 records OR specify records to show
    //csvDF.show()

    /*
     val dbDF = ss.read.format("jdbc").options(
     Map("url" -> "jdbc:mysql://127.0.0.1:3306/slz_core",
                  "user" -> "slz02",
                  "password" -> "slz02@123",
                  "dbtable" -> "regions"))
              .load()
     */

  }
}
