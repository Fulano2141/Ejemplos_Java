package quartzdemo;
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;



import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.*;
public class QuartzSchedulerExample implements ILatch {

    private int repeatCount = 3;

    private CountDownLatch latch = new CountDownLatch(repeatCount + 1);

    public static void main(String[] args) throws Exception {  

        QuartzSchedulerExample quartzSchedulerExample = new QuartzSchedulerExample();

        quartzSchedulerExample.fireJob();

    }

     

    public void fireJob() throws SchedulerException, InterruptedException {

        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

        Scheduler scheduler = schedFact.getScheduler();

        scheduler.start();

         

        // define the job and tie it to our HelloJob class

        JobBuilder jobBuilder = JobBuilder.newJob(SimpleJob.class);

        JobDataMap data = new JobDataMap();

        data.put("latch", this);

         

        JobDetail jobDetail = jobBuilder.usingJobData("example", "com.javacodegeeks.quartz.QuartzSchedulerExample")

                .usingJobData(data)

                .withIdentity("myJob", "group1")

                .build();

         

         

        // Trigger the job to run now, and then every 40 seconds

        Trigger trigger = TriggerBuilder.newTrigger()

        .withIdentity("myTrigger", "group1")

        .startNow()

        .withSchedule(SimpleScheduleBuilder.simpleSchedule()

              .withRepeatCount(repeatCount)

                .withIntervalInSeconds(2))     

        .build();

         

        // Tell quartz to schedule the job using our trigger

        scheduler.scheduleJob(jobDetail, trigger);

        latch.await();

        System.out.println("All triggers executed. Shutdown scheduler");

        scheduler.shutdown();

    }

   
    public void countDown() {

        latch.countDown();

    }

}
