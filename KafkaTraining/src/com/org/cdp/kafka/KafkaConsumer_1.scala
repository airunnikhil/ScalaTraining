package com.org.cdp.kafka

import java.util.Properties
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition
import java.util.Arrays
import java.util.Properties
import java.util.Set

object KafkaConsumer_1 {
  def main(args : Array[String]) = {


    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    // When changed the consumer group, it behaves as a TOPIC or QUEUE
    props.put("group.id", "CONSUMER-GRP2")
    props.put("enable.auto.commit", "true")
    props.put("auto.commit.interval.ms", "1000")
    props.put("session.timeout.ms", "30000")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")


    val consumer = new KafkaConsumer[String, String](props)

    // Consumer consuming from a Particular Topic
    consumer.subscribe(Arrays.asList("PART4-TOPIC"))

    while (true) {
      val records = consumer.poll(1)

      records.forEach(new ForEacher)
    }
  }
}

class ForEacher extends java.util.function.Consumer[ConsumerRecord[String,String]] {
  override def accept(t: ConsumerRecord[String,String]): Unit = {
    println(t.key() + " - - - " + t.value())
  }
}
