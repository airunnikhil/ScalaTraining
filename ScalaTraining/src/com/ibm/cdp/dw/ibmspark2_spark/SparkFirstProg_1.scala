package com.ibm.cdp.dw.ibmspark2_spark

object SparkFirstProg_1 {
  def main(args : Array[String]) = {
    /*
    1. Config to your cluster
    2. Spark Context (config)
    3. Transformations (one or more)
    4. Action (one)
    5. close the spark context
    RDD - Resilient Distributed Data
      --RDDs are Immutable
      --Supports Lazy Loaded (inspired from Pig)
      --Distributed (chunk of file is distributed at nodes)
      --Resilient (Fault Tolerance), If deleted prev RDD state coz of LRU effect

    //Spark must always read from Storage - HDFS
    */
    import org.apache.spark.{SparkConf, SparkContext}

    //To find out how many processors core system has
    println(Runtime.getRuntime.availableProcessors())
    //local[<give number of processors or just *>]

    //Replace local[*] with actual cluster IP .. like
    // for spark cluster, "spark://192.168.1.1"
    // for kubernets cluster, "k8://192.168.1.1"
    val config = new SparkConf()
    config.setMaster("local[*]")
    config.setAppName("IBMJob")
    /*Or can combine
    config.setMaster("local[*]").setAppName("IBMJob")
     */

    // If Returns a RDD - its a Spark Transformation
    // If Returns any other Scala Data object - It's a Spark Action
    // A Spark program, MUST have at least one action after any number of Transformation. Action triggers all prior things to run

    val sc = new SparkContext(config)

    //When there's a long Lineage, do Checkpoint
    //Below saves to local but it must always be to HDFS

    //sc.setCheckpointDir("/home/vagrant/Desktop/")
    //Setting checkpoint folder also in HDFS
    sc.setCheckpointDir("hdfs://localhost:9000/checkpoints/")

    //--> This is Transformation
    val textFileRDD = sc.textFile("/home/vagrant/Desktop/auth.csv")

    //Checkpointing i.e. writing to storage/HDFS
    val chkptvar = textFileRDD.checkpoint()

    //--> This is action
    textFileRDD.foreach(each => println(each))

    //--> closing context
    sc stop

  }
}
