package com.ibm.cdp.dw.ibmspark

object CaseClasses_6 {
  def main(args: Array[String]): Unit ={

    val textList = List("Cassandra", "hbase", "cloudant")

    val newList = textList.map(each => {
      NoSQLDTO(each, each.length)
    })

    newList.foreach(each => {
      println(each.name + " " + each.lengthOfname)
    })

    println("")
  }
}

//Basically a template of data format/layout. Has no body
case class NoSQLDTO(name: String, lengthOfname: Int)

