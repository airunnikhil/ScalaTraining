package com.ibm.cdp.dw.ibmspark2

object TypeSafety_2 {
  def readString (input : String) = {

  }

  def readBoolean (input : Boolean) = {

  }

  def readDouble (input : Double) = {

  }

  // Type safety
  def read[A,B] (input:A, second: B) = {

    if (input.isInstanceOf[String]) {
      ////
    } else if(input.isInstanceOf[Boolean]) {
      ////
    } else if (input.isInstanceOf[Double]) {
      ////
    }
//    else if (second.isInstanceOf[CDPDTO]) {
      ////Some
//      Some("")
//    }
  }


  def readPro[A] (input:A) = {
    input match {
      case inputString : String => {  }
      case second: Boolean => {  }
      case third: Double => {  }
      case _ => { }
    }
  }


  def main(args : Array[String]) = {

    readPro(1000)
  }
}
