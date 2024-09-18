### As-is

**Objective**: Check the status every minute, and if the status is `true`, stop checking and initiate the request.

**Problem**: Occasionally, the request starts, but the task is not canceled.

### To-be

Through research, I discovered that `ScheduledExecutorService` must be shut down to properly terminate all scheduled tasks. Therefore, I tried a new approach using `ScheduledExecutorService` without relying on `customTaskScheduler`.

