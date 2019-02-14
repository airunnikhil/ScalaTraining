package com.ibm.cdp.dw.ibmspark2

class CSVFileReaderFactoryClass extends FileReaderFactoryTrait {

  //
  def readFileCSV: String = {
    //Code to open file
    ""
  }

  override def readFileName(fileVar: Int): Option[String] = {
    //Code to read the file name
    if (fileVar == 1)
      Some("auth.csv")
    else if (fileVar == 2)
      Some("out.csv")
    else
      None
  }

  override def readFileContent(): String = {
    "content_of_file"
  }
}
