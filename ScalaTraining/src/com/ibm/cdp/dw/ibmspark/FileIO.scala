package com.ibm.cdp.dw.ibmspark

import scala.collection.mutable.ListBuffer

import scala.io.Source
//Imports all underneath
import scala.io._

object FileIO {
  def main(args: Array[String]): Unit = {

    val csvFile = Source.fromFile("/home/vagrant/Desktop/auth.csv")

    var authcsvBuffer = new ListBuffer[authcsvDTO]

    //getLines will always read everything
    for (eachln <- csvFile.getLines()) {

      val cols = eachln.split(",")

      //If need to read based on some condition/value matching
      //if (cols(0).startsWith("a")){
      val objectDTO = authcsvDTO(cols(0), cols(3), cols(5))
      //}

      authcsvBuffer += objectDTO

    }

    val useDTOBuffer = authcsvBuffer.map(each => println(each.refID))

    //To only iterate 50 records
    val authList = authcsvBuffer.toList
    val takeList = authList.take(50)

    //?how to print those 50 records
    takeList.foreach(each => println(each))

    //How to Break from even reading

    import scala.util.control.Breaks
    val loop = new Breaks

    for (eachln <- csvFile.getLines()) {
      val cols = eachln.split(",")

      //loop.breakable{

      val objectDTO = authcsvDTO(cols(0), cols(3), cols(5))
      authcsvBuffer += objectDTO

      //  if (//add condition to break)
      //  )
      //    loop.break()
      //}
    }
    //--------------------------------------------------------------------------
    import java.io.{File, PrintWriter => IBMPrinterWriter}

    val writer = new IBMPrinterWriter(new File("out.csv"))

    println("Writing to new file...")
    val dataList = List("cassandra", "cloudant", "redis", "data-mongodb")

    dataList.foreach(each => writer.write(each + ","))

    //Writing Buffer back to csv file
    //authcsvBuffer.foreach(each => writer.write(each))

    writer.close()
  }
}
case class authcsvDTO(refID: String, aua: String, version: String)
