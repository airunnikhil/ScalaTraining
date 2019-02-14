package com.ibm.cdp.dw.ibmspark2_spark

object SparkClusterJob_4 {
  def main(args: Array[String]): Unit ={

    //Suppressing Logs
    import org.apache.log4j.{Level,Logger}

    // val rootLogger=Logger.getRootLogger()
    // rootLogger.setLevel(Level.ERROR)
    //
    // import org.apache.log4j.{Level, Logger}
    // Logger.getLogger("org").setLevel(Level.OFF)


    import org.apache.spark.{SparkConf, SparkContext}

    //Spark config context
    val config = new SparkConf()

    //config.setMaster("spark://ubuntu:7077")
    config.setMaster("local[*]")
    config.setAppName("IBMJob4")

    val sc = new SparkContext(config)

    //Outside the transformation piece
    val cdpAccumulator = sc.longAccumulator("CDPAccumulator")
    //val cdpRuleBC = sc.broadcast(CDPRuleDTO(List("cr1", "cd2")))

    //Transformations
    //Specify another operator like 30; to say how many partitions to create
    val textFileRDD = sc.textFile("hdfs://localhost:9000/ibm/auth.csv", 30)

    val mappedRDD = textFileRDD.map(each => {
      //Gives values of Broadcaster, to the workers
      //val bc = cdpRuleBC.value

      //printing the DTO data
      //bc.rules.foreach(println)
      val columns = each.split(",")

      if (columns(0).startsWith("a"))
        cdpAccumulator.add(1L)

      columns(0)
    })

    mappedRDD.collect().foreach(println)

    println(cdpAccumulator.value)
  }
}
case class CDPRuleDTO(rules : List[String])