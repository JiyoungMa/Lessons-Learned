package com.lessons_learned.spring_webflux.taskscheduler.tobe

import com.lessons_learned.spring_webflux.taskscheduler.asis.*
import org.springframework.stereotype.*
import java.time.*
import java.util.concurrent.*
import kotlin.random.*

@Service
class DoSomethingScheduler{
    private var customTaskScheduler: ScheduledExecutorService? = null
    private var schedule: ScheduledFuture<*>? = null

    fun startRequesting(){
        if(customTaskScheduler == null){
            customTaskScheduler = Executors.newSingleThreadScheduledExecutor()
        }

        schedule = customTaskScheduler!!.scheduleAtFixedRate(
            startRequestingIfStatusIsTrue(),
            0,
            1,
            TimeUnit.SECONDS
        )
    }

    private fun startRequestingIfStatusIsTrue(): Runnable{
        return Runnable{
            val status = randomEvenCheck()
            if (status){
                schedule?.cancel(true)
                customTaskScheduler?.shutdown()
                customTaskScheduler = null
                request()
            }

        }
    }

    private fun randomEvenCheck(): Boolean {
        val randomNumber = Random.nextInt(1, 11)
        return randomNumber % 2 == 0
    }

    private fun request(){
        println("REQUEST")
    }
}