package com.mkrdeveloper.flowyt

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MainRepository {

    fun generateNumber() = sequence {
        for (i in 1..10) {
            yield(i)
            Thread.sleep(1000) // simulate a delay
        }
    }

    fun simpleFlow(): Flow<Int> = flow {
        for (i in 1..10) {
            emit(i) // emit the next value
            delay(1000) // simulate a delay

        }
    }
}