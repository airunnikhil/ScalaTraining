package com.ibm.cdp.dw.ibmspark2_spark

import org.apache.spark.storage.StorageLevel

//Spark Transformations -- solving problem of wordcount from slide74
object SparkClusterJob_5 {

  def main(args: Array[String]): Unit ={
    import org.apache.spark.{SparkConf, SparkContext}
    val config = new SparkConf()
    //Change from local[*] to Master URI if only building using build xml/jar and deploy to Spark Job
    config.setMaster("local[*]")
    config.setAppName("IBMJob5")

    val sc = new SparkContext(config)

    //val textFileRDD = sc.textFile("hdfs://localhost:9000/ibm/shuffle.text", 30)
    val textFileRDD = sc.textFile("/home/vagrant/Desktop/shuffle.text", 30)

    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      columns(0)
    })

    val flatMappedRDD = textFileRDD.flatMap(each => each.split(" "))

    //Caching / persisting the RDD into disk or memory only
    flatMappedRDD.persist(StorageLevel.MEMORY_ONLY)
    flatMappedRDD.cache()

    val flatmapRDD = flatMappedRDD.map(each => (each,1))
    val reducedRDD = flatmapRDD.reduceByKey((x,y) => x+y)
    reducedRDD.foreach(each => println(each))

    //More Spark Transformations
    /*
    mappedRDD.filter(each => each.startsWith("a"))
    mappedRDD.repartition(10).getNumPartitions

    mappedRDD.union(mappedRDD)
    mappedRDD.intersection(mappedRDD)
    mappedRDD.zip(mappedRDD)
    mappedRDD.zipWithIndex()
    mappedRDD.cartesian(mappedRDD)
    mappedRDD.pipe("ls -lart")
    mappedRDD.sample(false, 0.2)*/

    //Doing catesian Spark trans
    println("Cartesian product is...")
    mappedRDD.cartesian(mappedRDD).foreach(println)

    flatMappedRDD.unpersist()

    sc stop
  }
}