package com.org.cdp.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

object KafkaProducer_2 {
  def main(args:Array[String]) = {
    // zkNode - 2181
    // kafka - localhost - 9092

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092,localhost:9095")
    props.put("client.id", "UNIQUE-PRODUCER_ID")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("linger.ms", "1")
    props.put("batch.size","445")
    props.put("request.required.acks", "-1")

    val producer = new KafkaProducer[String, String](props)

    val data = new ProducerRecord[String, String]("BROKE2-TOPIC",3,"Oxy", "Testing Part4 Broker2 Spec Part Implementation - Oxy")
    val data2 = new ProducerRecord[String, String]("BROKE2-TOPIC",3,"Hyd", "Testing Part4 Broker2 Spec Part Implementation - Hyd")
    val data3 = new ProducerRecord[String, String]("BROKE2-TOPIC",3,"Nit", "Testing Part4 Broker2 Spec Part Implementation - Nit")

    try {
      // Scala producer with a callback
      producer.send(data)
      producer.send(data2)
      producer.send(data3)
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
