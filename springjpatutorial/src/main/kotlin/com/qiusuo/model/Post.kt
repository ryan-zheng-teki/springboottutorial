package com.qiusuo.model

import javax.annotation.Generated
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Post(var title: String, @Id @Generated var id: Long? = null) {
    constructor() : this("") {
    }
}