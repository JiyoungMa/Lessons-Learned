### As-is

**Objective**: Check the status every minute, and if the status is `true`, stop checking and initiate the request.

**Problem**: Occasionally, the request starts, but the task is not canceled.

### To-be

By searching, I discovered that ScheduledExecutorService 
