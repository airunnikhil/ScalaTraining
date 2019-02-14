package com.ibm.cdp.dw.ibmspark2

//sealed enforces all it's classes must be implemented in same file, Sealed works on Classes as well
//sealed trait FileReaderFactoryTrait {
trait FileReaderFactoryTrait {

  //What to do

  def readFileName(fileVar: Int) : Option[String]

  def readFileContent(): String

}

/*
class CSVFileReaderFactoryClass extends FileReaderFactoryTrait{
  override def readFileName(): Option[String] = {}

  override def readFileContent(): String = {}
}
*/
