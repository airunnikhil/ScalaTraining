package com.ibm.cdp.dw.ibmspark

import scala.collection.mutable.ListBuffer

object MutableCollections_7 {

  def main(args: Array[String]): Unit ={

    //if need Mutable Heteregenous List = use Buffer
    val buffer = new ListBuffer[String]
    buffer += "newElement"

    //OR

    //List really can't be mutable
    var listData = List("cassandra", "hbase", "cloudant")
    var mutableList = listData.toBuffer
    mutableList += "mongoDB"
    val dList = listData.toList

    //----------------------------------------------------


    val hList = List("cassandra", 102f, true, 899d)

    hList.foreach(each => {
      if (each.isInstanceOf[String])
        println(each)
    })

    //Mutable Collections are available for Set and Map
    import scala.collection.mutable.Set
    var nosqlDataList = Set("cassandra", "hbase", "cloudant")

    nosqlDataList.add("mongodb")

    import scala.collection.mutable.Map
    val map = Map(1101 -> "Cache")

    //Printing Map, returns a Tupel list
    map.foreach(each => println(each._1 + each._2))
  }
}
