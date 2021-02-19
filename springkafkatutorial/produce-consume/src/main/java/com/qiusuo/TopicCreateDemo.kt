package com.qiusuo

import org.apache.kafka.common.utils.Time.SYSTEM
import java.sql.Time
import javax.swing.text.html.parser.DTDConstants.SYSTEM

class TopicCreateDemo {

}

fun main(args: Array<String>) {
    val zookeeperHost  = "127.0.0.1:2181"
    val isSucre = false

    val connectionTimeoutMs = 15000
    val maxInFlightRequests = 10
    val metricGroup = "myGroup"
    val metricType = "myType"
    val zkClient: KafkaZkClient = KafkaZkClient.apply(zookeeperHost, isSucre, sessionTimeoutMs,
            connectionTimeoutMs, maxInFlightRequests, time, metricGroup, metricType)
    val adminZkClient = AdminZkClient(zkClient)
}