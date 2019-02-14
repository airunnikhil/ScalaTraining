package com.ibm.cdp.dw.ibmspark

object Collections_5 {

  //Collections
  //List (allows Duplicates) | Set (only allows Unique) | Map (Key value pair) | Tuple (Heterogenious), can hold max of 22 elements | Array | Range
  def main(args: Array[String]): Unit = {
    //Function literral in Scala / Lamda expression in Java. Anonymous functions
    //Syntax x => {}
    //Python Syntax lambda ibm :
    //Lamda expressions can be defined and can be called later

    var textList = List("Cassandra", "hbase", "cloudant")

    val intList = List(1, 2, 3)

    //classic for loop
    for (i <- textList) {
      println(i)
    }

    //foreach loop
    val listIterate = textList.foreach(x => {
      println(x)
    })

    //Map Transformation Functions - part of inbuilt Scala
    val changedTextList = textList.map(each => {
      each.toUpperCase()
    })

    println("Map Transformation: Printing List after Uppercase")
    changedTextList.foreach(each => {
      println(each)
    })
    //--------------------------------------------------------------------------------

    var textList2 = List("Cassandra", "hbase", "cloudant")
    var textSet = Set("Cassandra", "hbase", "cloudant", "Cassandra")
    /*      var keyvalueMap = Map(1001 -> "Value1",
                            1002 -> "Value2",
                            1003 -> "Value3",
      )
*/
    val hetrogenTuple = ("Data", 1005f, true)
    println(hetrogenTuple._1)

    val range100 = 1 to 100 by 2
    val range99 = 1 until 100

    range100.foreach(x => {
      println(x)
    })

    //After Scala 2.9 version, it allows Heteregenous list as well
    val hList = List("cassandra", 102f, true, 899d)

    hList.foreach(each => {
      if (each.isInstanceOf[String])
        println(each)
    })
  }
}
