package com.qiusuo.data.cache

/**
 * Cache contains all the objects. Currently we only want to store the Tables
 */
class Cache<T> {
    var objects = HashSet<T>()

    /**
     * The core of cache is get or compute. When we can not get its value, then
     * we should compute. The cache should be pure. It should not know anything
     * about how to compute. that means the key should be able to do the compute
     * as as well.
     */
    fun getOrCompute(key: String): Any? {
        return null;
    }
}