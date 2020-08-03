package com.sarcobjects.DevOffDesafio2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CrypterTest {
    var crypter = Crypter()

    @Test
    fun testEncrypt() {
        val result = crypter.encrypt(Ask(4, "Devoff se puso ATR"))
        Assertions.assertEquals(Response("DfesTef oRv p osuA"), result)
    }

    @Test
    fun testDecrypt() {
        val result = crypter.decrypt(Ask(4, "DfesTef oRv p osuA"))
        Assertions.assertEquals(Response("Devoff se puso ATR"), result)
    }
}