package com.ibm.cdp.dw.ibmspark2_spark

import org.apache.spark.sql.SparkSession

object SparkClusterJob_7_SparkSession {
  def main(args: Array[String]): Unit ={

    //SparkSession Umbrella API, abstracts all
    //------------------------------------------------
    //      Core       SQL             Streaming
    //1.6// RDD        Dataframe       DStreams
    //2.0//---changed to SparkSession, obviously is backward compatible

    val ss = SparkSession.builder()
      .appName("IBMJob7").master("local[*]").getOrCreate()
    val sc = ss.sparkContext

    val textFileRDD = sc.textFile("hdfs://localhost:9000/ibm/auth.csv/")

      println("Number of Partitions are ..." + textFileRDD.getNumPartitions)
      //Or
      //println("Other way to know Number of Partitions are ..." + textFileRDD.partitions.length)

    textFileRDD.count()

    sc stop
  }
}