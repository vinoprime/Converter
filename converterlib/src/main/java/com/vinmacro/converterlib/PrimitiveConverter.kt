package com.vinmacro.converterlib

class PrimitiveConverter {

    companion object {

        @JvmStatic
        fun toInt(b: Byte): Int {
            return b.toInt() and 0xFF
        }

        @JvmStatic
        fun toByte(c: Int): Byte {
            return (if (c <= 0x7f) c else c % 0x80 - 0x80).toByte()
        }
    }
}