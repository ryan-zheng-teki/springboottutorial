package com.qiusuo.webfluxtutorial.domain

import jakarta.persistence.Entity
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable


/*
In kotlin private var will generate getter and setter. by default the property is public
 */
@Entity
class User(private @Id var id: String, var name: String, private @Transient var isNew: Boolean): Persistable<String> {
    private lateinit var books: List<Book> //lazyinit means that i can not provide the value now
    override fun getId(): String = id
    override fun isNew(): Boolean = isNew
}