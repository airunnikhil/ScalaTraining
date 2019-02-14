package com.ibm.cdp.dw.ibmspark2

class XMLFileReaderFactoryClass extends FileReaderFactoryTrait {

    //
    def readFileXML: String = {
      //Code to open file
        ""
    }

    //Best practice to use Option and Some/None, this avoids Null pointer exception problem of Java
    //Under Option could also be any other case class/DTO or other object as well
    override def readFileName(fileVar: Int): Option[String] = {
      //Code to read the file name
      if (fileVar == 1)
        Some("auth.csv")
      else if (fileVar == 2)
        Some("out.csv")
      else
        None

      /*
      def doComplexProcessing(input : Int) : Option[CDPDTO] = {
        if (input==10)
          Some(CDPDTO(1001, "mainframe"))
        else if (input == 20)
          Some(CDPDTO(1002, "mainframe"))
        else None
        }
       case class CDPDTO(id: Int, name:String)
       */
    }

    override def readFileContent(): String = {
      "content_of_file"
    }


}
