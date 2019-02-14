package com.ibm.cdp.dw.ibmspark

object Methods_1 {

  def main(args: Array[String]): Unit = {
    //:Unit is default (same as void in Java)
    //Ctl+Space bar to get IntelliSense suggestion

    println("I'm in Main")
    processData(100,"Cloudant")

    //Different Type of Functions

    logwarn("Throwing an error")
    processData(data = "COMPUTED_DATA")
    fetchLicenseRecords(pageStart=102, tableName = "TABLE",
      pageEnd = 102, fetchStrategy = "EAGER")

    saveAUA("aua1", "aua2", "aua3")
  }

  //Can force a default value, if not passed while calling
  def processData(id: Int = 2000, data: String): Unit ={
    println("I'm in ProcessData")
    println(id + " " + data)

    println(processNewData(200,"COS"))
  }


  def processNewData(id: Int, data: String): Int ={
    //Do some computation

    println("I'm in ProcessNewData")
    300
  }

  //Different Syntax of Functions - refer from slide#443

  //Procedure, doesn't return anything. String Interpolation
  def logwarn(warningMsg: String) = println(s"Logging a warning message - $warningMsg")

  def retrieveNOSQL() : String = "REDIS"

  def fetchLicenseRecords(tableName : String, pageStart : Int,
                          pageEnd : Int,
                          fetchStrategy: String) : Boolean = {
    println("TableName - " + tableName)
    return true

  }

  def ++ (input : String) : String = {
    input.concat(input)
  }

  def +!@%%%%%%^&* (input : String) : String = {
    "COMPLEX_NAMING"
  }

  //Can pass n number of unknown number of values
  def saveAUA(aua : String*) : Unit = {
    for (i <- aua)
      println(i)

  }
}
