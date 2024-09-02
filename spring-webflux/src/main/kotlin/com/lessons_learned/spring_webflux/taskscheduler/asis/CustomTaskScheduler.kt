package com.lessons_learned.spring_webflux.taskscheduler.asis

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.util.concurrent.*
import java.util.concurrent.*

class CustomTaskScheduler: ThreadPoolTaskScheduler() {
}