package com.ibm.cdp.dw.ibmspark2_spark

import org.apache.spark.sql.SparkSession

object DB2Connect {
  def main(args: Array[String]): Unit ={

    val ss = SparkSession.builder()
      .appName("IBMJob8")
      .master("local[*]")
      .getOrCreate()

    val dbDF = ss.read.format("jdbc").options(
      Map("url" -> "jdbc:db2://meub7.vipa.uk.ibm.com:446/UKMFG8",
        "user" -> "in42322",
        "password" -> "nov22epr",
        "dbtable" -> "CTMPL.CTMTTRN"))
      .load()

    dbDF.show()
  }
}
