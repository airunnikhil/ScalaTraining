package com.ibm.cdp.dw.ibmspark

object Transformations_9 {

  def main(args : Array[String])  = {

    val dataList = List("cassandra", "cloudant", "redis", "data-mongodb", "cloudant")

    println("Header of list is " + dataList.head)

    println("Tail list is ")
    val tailList = dataList.tail
    //tailList.foreach(each => println(each))

    println("Distinct Tail Filtered list is ")
    val multiList = dataList.tail
                            .distinct
                            .filter(each => each.startsWith("c"))
                            .tail
    //Can go to any number of Transformation

    //All 3 works same way
    multiList.foreach(each => println(each))
    multiList.foreach(println)
    multiList.foreach(println(_))

    //Partition list printing
    println("Partition satisfied list is ")
    val partitionList = dataList.partition(each => each.startsWith("c"))

    //Values that satisfies the partitioned condition
    partitionList._1.foreach(println)
    //Values that doesn't satisfy the partitioned condition
    partitionList._2

    //Removing first number of values from List
    dataList.drop(2)

    println("Union list is ")
    //Union doesn't work on different collections (i.e. List and Tuple can't be
    val ulist = dataList.union(dataList)
    ulist.foreach(each => println(each))

    println("Multi list is ")
    dataList.tail
              .filter(each => each.contains("da"))
                .drop(1)
                .distinct
                  .zipWithIndex
                .foreach(println)

    //zip does actual Union i.e. one to one value from one list to another, makes a Map/tuple
    //zipwithIndex adds values own index, makes a Map/Tuple


    //More Transformations discussed on
    val list = List(1,2,3,4,5)

    //Returns Sum (15), If performed with String, it will concatenate
    val outvar = list.reduceLeft((x,y) => x+y)
    //OR
    /*
    val outvar2 = list.reduceRight(_+_)

    //Binary Iteration
    println("Reduced binary list is..")
    println(list.reduce(_+_))

    //Considers provided 10 value as Seed, starts from there to add
    list.foldLeft(10)(_+_)
*/
  }
}
