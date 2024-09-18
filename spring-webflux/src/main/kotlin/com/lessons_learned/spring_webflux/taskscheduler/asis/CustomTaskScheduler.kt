package com.lessons_learned.spring_webflux.taskscheduler.asis

import org.slf4j.LoggerFactory
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.stereotype.*
import org.springframework.util.concurrent.*
import java.time.*
import java.util.*
import java.util.concurrent.*

@Component
class CustomTaskScheduler: ThreadPoolTaskScheduler() {
    private val log = LoggerFactory.getLogger(this::class.java)

    private val scheduledTasks: MutableMap<String, ScheduledFuture<*>> = IdentityHashMap()

    fun scheduleAtFixedRate(task: Runnable, period: Duration, id: String){
        val future: ScheduledFuture<*> = super.scheduleAtFixedRate(task,period)
        scheduledTasks[id] = future
    }

    fun cancelScheduledTask(id: String){
        val future = scheduledTasks[id]
        future?.cancel(true) ?: log.error("Fail to cancel scheduled Task $id")
    }
}