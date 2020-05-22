package com.qiusuo.springbootredis.domain;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/*
In redis, each data structure is accessed by a key. The hash data structure is accessed by a key.
In the data structure, we define the name of the key, and the value of the key.
Since redis hash is about a dictionary. Then we could have many students.
 */
@RedisHash("Student")
public class Student implements Serializable {

    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;
    private int grade;
    // ...
}
