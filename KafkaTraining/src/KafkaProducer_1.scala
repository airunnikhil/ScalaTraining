package com.org.cdp.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object KafkaProducer_1 {
  def main(args:Array[String]) = {
    // zkNode - 2181
    // kafka - localhost - 9092

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("client.id", "UNIQUE-PRODUCER_ID")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","445")
    props.put("request.required.acks", "-1")

    val producer = new KafkaProducer[String, String](props)
    /*
    val data = new ProducerRecord[String, String]("NICK-TOPIC","zeonNew", "kafka is ultimate messaging")
    val data2 = new ProducerRecord[String, String]("NICK2-TOPIC","zeon2", "kafka is extreme2 messaging")
    val data3 = new ProducerRecord[String, String]("NICK2-TOPIC","zeon3", "kafka is valuable3 messaging")
    val data4 = new ProducerRecord[String, String]("NICK-TOPIC","zeonNew2", "kafka is only good4 messaging")
    */
    val data = new ProducerRecord[String, String]("PART4-TOPIC","Oxy", "Testing Part4 Implementation - Oxy")
    val data2 = new ProducerRecord[String, String]("PART4-TOPIC","Hyd", "Testing Part4 Implementation - Hyd")

    try {
      // Scala producer with a callback
      producer.send(data)
      producer.send(data2)
      /*producer.send(data3)
      producer.send(data4)*/
    }
    catch {
      case ex: Exception =>{
        println(ex)
      }

    }
    // Kafka producer produces a flush method to ensure all previously sent messages have been actually completed.
    producer.flush()
    producer.close()

  }
}
