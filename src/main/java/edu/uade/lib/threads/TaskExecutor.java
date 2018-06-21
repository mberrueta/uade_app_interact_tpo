package edu.uade.lib.threads;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskExecutor {
    private static final Logger log = Logger.getLogger("TaskExecutor");

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    Task myTask;
    private long runEachMinutes;

    public TaskExecutor(Task myTask$, long runEachMinutes) {
        myTask = myTask$;
        this.runEachMinutes = runEachMinutes;
    }

    public void startExecution() {
        Runnable taskWrapper = () -> {
            System.out.printf("Starting task %s at %s\n", myTask.getClass().getName(), getCurrentDateTime());
            String result = myTask.run();
            startExecution();
            System.out.printf("Executed task %s at %s.\n->\n%s\n\n", myTask.getClass().getName(), getCurrentDateTime(), result);
        };
        executorService.schedule(taskWrapper, runEachMinutes, TimeUnit.MINUTES);
    }

    private String getCurrentDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        return strDate;
    }
}