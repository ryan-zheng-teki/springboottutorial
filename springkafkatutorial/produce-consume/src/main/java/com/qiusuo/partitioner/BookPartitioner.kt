package com.qiusuo.partitioner

import org.apache.kafka.clients.producer.Partitioner
import org.apache.kafka.common.Cluster

private const val PARITION_COUNT = 50

class BookPartitioner : Partitioner {
    override fun configure(configs: MutableMap<String, *>?) {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun partition(
        topic: String?,
        key: Any?,
        keyBytes: ByteArray?,
        value: Any?,
        valueBytes: ByteArray?,
        cluster: Cluster?
    ): Int {
        val keyInt = key.toString().toInt()
        return keyInt % PARITION_COUNT
    }
}