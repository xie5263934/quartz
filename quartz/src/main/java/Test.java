import com.quartz.test.SimpleQuartJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

/**
 * @author JINRUN.XIE
 * @since 2017/5/18
 */
public class Test {
    public static void main(String [] args) throws SchedulerException {
        Test test = new Test();
        test.tasck();
    }

    public void tasck() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = new JobDetailImpl("jobDetail-s1","jobDetailGroup-s1",SimpleQuartJob.class);
        SimpleTrigger simpleTrigger = new SimpleTriggerImpl("simpleTrigger1","triggerGroup-s1",10,10000);
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        scheduler.start();
    }
}
