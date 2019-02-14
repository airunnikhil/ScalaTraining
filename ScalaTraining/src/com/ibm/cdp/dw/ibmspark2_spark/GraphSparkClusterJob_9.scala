package com.ibm.cdp.dw.ibmspark2_spark

import org.apache.spark.{SparkConf, SparkContext}

object GraphSparkClusterJob_9 {
  def main(args: Array[String]): Unit ={

    val config = new SparkConf()
    config.setMaster("spark://ubuntu:7077")
    config.setAppName("IBMJob")

    val sc = new SparkContext(config)

    val textFileRDD = sc.textFile("/home/vagrant/Desktop/auth.csv")

    textFileRDD.foreach(each => println(each))

    //--> closing context
    sc stop
}
}
