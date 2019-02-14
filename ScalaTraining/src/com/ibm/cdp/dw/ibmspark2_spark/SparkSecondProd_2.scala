package com.ibm.cdp.dw.ibmspark2_spark

object SparkSecondProd_2 {
  def main(args : Array[String]) = {
    import org.apache.spark.{SparkConf, SparkContext}


    val config = new SparkConf()
    config.setMaster("local[*]")
    config.setAppName("IBMJob")

    val sc = new SparkContext(config)

    //val textFileRDD = sc.textFile("/home/vagrant/Desktop/auth.csv")

    //Referring from HDFS itself
    val textFileRDD = sc.textFile("hdfs://localhost:9000/ibm/auth.csv")

    val authDTORDD = textFileRDD.map(each => {
      val cols = each.split(",")
      AuthDTO(cols(0),cols(3),cols(5))
    })

    val mappedRDD = authDTORDD.map(each => println(each))
    //val mappedRDD = authDTORDD.map(each => each)

    //Spark Actions
    println("Spark action is working now...")
    //mappedRDD.foreach(each => println(each))

    //println(mappedRDD.count())
    //mappedRDD.collect()
    //mappedRDD.take(10)
    //mappedRDD.first()

    sc stop
  }

  case class AuthDTO(refID: String, aua: String, ver: String)
}
