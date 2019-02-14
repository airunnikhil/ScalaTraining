package com.ibm.cdp.dw.ibmspark2

object SparkFirst_1 {

   def main(args : Array[String]) = {
      /*
      1. Config to your cluster
      2. Spark Context (config)
      3. Transformations (one or more)
      4. Action (one)
      5. close the spark context
      RDD - Resilient Distributed Data
      */
      import org.apache.spark.{SparkConf, SparkContext}

      val config = new SparkConf()
      config.setMaster("local[*]")
      config.setAppName("IBMJob")
      val sc = new SparkContext(config)
      val textFileRDD = sc.textFile("/home/vagrant/Desktop/auth.csv")
      textFileRDD.foreach(each => println(each))
      sc stop

  }

}
