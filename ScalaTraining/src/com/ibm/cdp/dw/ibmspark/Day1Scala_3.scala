package com.ibm.cdp.dw.ibmspark

object Day1Scala_3 {

  def main(args: Array[String]): Unit ={

    val call1 = new FirstClass_4();
    val call2 = new FirstClass_4()
    var call3 = new FirstClass_4

    //OR
    new FirstClass_4().processXML("calling without var")

    call1 processXML("calling with braces")

    call2 processXML "calling without braces"
    //-------------------------------------------------------------

  //calling the Object method, no need to use new. Singleton class, all methods underneath are Static. Single instance/object in memory
    ClassVsObjectDiff.processCalc("Hi")
    //-------------------------------------------------------------
  }
}
