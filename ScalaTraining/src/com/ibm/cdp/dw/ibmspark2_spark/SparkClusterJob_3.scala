package com.ibm.cdp.dw.ibmspark2_spark

object SparkClusterJob_3 {

  def main(args: Array[String]): Unit ={

    import org.apache.spark.{SparkConf, SparkContext}

    //Spark config context
    val config = new SparkConf()

    //config.setMaster("local[*]")
    config.setMaster("spark://ubuntu:7077")
    config.setAppName("IBMJob3")

    val sc = new SparkContext(config)

    val dataList = List("cassandra","hbase")

    //Spark Transformations

    //Other ways to create the RDD; Reading from your program
    val listRDD = sc.parallelize(dataList)

    //val rangeRDD = sc.range(1,100,3,4)

    val textFileRDD = sc.textFile("hdfs://localhost:9000/ibm/auth.csv")

    //Spark Action
    println("Spark action is working now...")
    println(textFileRDD.count())

    //Saving the RDD as Text File in HDFS
    listRDD.saveAsTextFile("hdfs://localhost:9000/SparkClusterJob_3_listRDD/")

    //Saving the RDD as Text File in HDFS
    //textFileRDD.saveAsTextFile("hdfs://localhost:9000/SparkClusterJob_3/")

    //Saving it as Obj file
    //textFileRDD.saveAsObjectFile("hdfs://localhost:9000/SparkClusterJob_3_Obj/")

    //Spark Context Close
    sc stop

  }
}
