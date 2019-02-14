package com.ibm.cdp.dw.ibmspark

object HOF_10 {
  def main(args: Array[String]): Unit ={

    arithmetic(subtract, 3,5)

    arithmetic((x,y) => x+y, 3,5)

    arithmetic(_*_, 3,5)

  }
  def arithmetic(fn : (Int,Int) => Int, firstNumber : Int,
                 secondNumber:Int) = {

    fn(firstNumber,secondNumber)

  }


  def sum(first:Int, second:Int) = {
    first+second
  }


  def subtract(first:Int, second:Int) = {
    first-second
  }

}

