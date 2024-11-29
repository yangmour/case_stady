package com.work.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kts")
class HelloController {
    @RequestMapping("hello")
    fun hello(): String {
        return "Hello World!"
    }
}