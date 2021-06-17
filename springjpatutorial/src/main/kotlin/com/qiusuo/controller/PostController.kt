package com.qiusuo.controller

import com.qiusuo.model.Post
import com.qiusuo.repository.PostRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PostController(val postRepository: PostRepository) {
    @GetMapping("/hello")
    fun posts(): String {
        var post = Post("hello")
        postRepository.save(post)
        return "blog"
    }
}