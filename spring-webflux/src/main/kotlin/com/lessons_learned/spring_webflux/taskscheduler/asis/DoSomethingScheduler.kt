package com.lessons_learned.spring_webflux.taskscheduler.asis

import org.springframework.stereotype.Service
import kotlin.random.Random
import java.time.*
import java.util.*

@Service
class DoSomethingScheduler(
    private val customTaskScheduler: CustomTaskScheduler,
) {

    fun startRequesting(){
        customTaskScheduler.scheduleAtFixedRate(
            startRequestingIfStatusIsTrue(),
            Duration.ofMinutes(1L),
            CUSTOM_TASK_SCHEDULE_ID
        )
    }

    private fun startRequestingIfStatusIsTrue(): Runnable{
        return Runnable{
            val status = randomEvenCheck()
            if (status){
                customTaskScheduler.cancelScheduledTask(CUSTOM_TASK_SCHEDULE_ID)
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

    companion object{
        private const val CUSTOM_TASK_SCHEDULE_ID = "StatusIfTrueTask"
    }
}