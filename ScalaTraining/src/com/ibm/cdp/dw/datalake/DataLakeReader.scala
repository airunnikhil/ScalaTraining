package com.ibm.cdp.dw.datalake

class DataLakeReader {

  def readCloudObject() ={

    new ReadCloudObject().readFile()

  }

  def readHDFSFile() = {

    new ReadHDFSFile().readFile()
  }


  def readFile(rdl : ReadDataLake) = {
    rdl.readFile()
  }

}


