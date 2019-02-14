package com.ibm.cdp.dw.ibmspark

object Implicits_11 {
  def main(args: Array[String]): Unit ={
    //Implicit var under scope of {}
    {implicit val floatValue = 167f}

    //Implicit var under scope of main method
    implicit val floatValue2 = 187f

    implicit val intValue = 567

    getMeRoundedNumberOfFloat
    work("Nick")
  }

  def getMeRoundedNumberOfFloat(implicit anyFloatValue : Float) { println(anyFloatValue)    }
  def work(nameOfPerson: String) (implicit durationOfWork : Int) = { println("Name of the person and the hours he worked - " + nameOfPerson + " - " + durationOfWork) }

  //Refer Slide 545 for more examples on Implicit

}
