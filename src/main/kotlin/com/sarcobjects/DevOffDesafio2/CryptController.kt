package com.sarcobjects.DevOffDesafio2

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/crypt")
class CryptController(val crypter: Crypter) {


    @PostMapping("/encrypt")
    fun encrypt(@RequestBody ask: Ask): Response {
        return crypter.encrypt(ask)
    }

    @PostMapping("/decrypt")
    fun decrypt(@RequestBody ask: Ask): Response {
        return crypter.decrypt(ask)
    }
}