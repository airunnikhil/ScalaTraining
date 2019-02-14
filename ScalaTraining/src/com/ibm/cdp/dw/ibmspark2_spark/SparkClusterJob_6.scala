package com.ibm.cdp.dw.ibmspark2_spark

//Writing Custom Partitioner and Doing partition specific business logic

import org.apache.spark.Partitioner

object SparkClusterJob_6 {
  def main(args: Array[String]): Unit ={
    import org.apache.spark.{SparkConf, SparkContext}
    val config = new SparkConf()
    config.setMaster("local[*]")
    config.setAppName("IBMJob6")

    val sc = new SparkContext(config)

    val textFileRDD = sc.textFile("hdfs://localhost:9000/ibm/auth.csv", 30)

    val mappedRDD = textFileRDD.map(each => {
      val columns = each.split(",")
      (columns(2), columns(3))
    })

    val partitionedRDD = mappedRDD.partitionBy(new AuthDataPartitioner)

    partitionedRDD.saveAsTextFile("hdfs://localhost:9000/SparkClusterJob_6_partRDD/")

    mappedRDD.foreach(each => println(each._1 + " --- " + each._2))

    //Writing Business logic based on specific Partition

    val finalRDD = partitionedRDD.mapPartitionsWithIndex(
      //Takes 2 param, Which partition number is it and Data Iterator(Cursor)
      (partitionIndex, dataIterator) => {

        dataIterator.map(dataInfo =>

          if (partitionIndex==26) {
            //Business logic
            //println(dataInfo._1, dataInfo._2)
            (dataInfo._1, dataInfo._2)
          }
          else {
            //business logic
            //println(dataInfo._2, dataInfo._1)
            (dataInfo._2, dataInfo._1)
          }
        )
      })

//Only if there are 2 value pairs, can be saved as Sequence file
    finalRDD.saveAsSequenceFile("hdfs://localhost:9000/SparkClusterJob_6_finalRDD")

    sc stop
  }
}

class AuthDataPartitioner extends Partitioner {

  override def numPartitions: Int = 100

  override def getPartition(key: Any): Int = {

    val auaKey = key.asInstanceOf[String]

    if (auaKey.equals("340000")) 78
    else if (auaKey.equals("740000")) 26
    else 30

  }
}