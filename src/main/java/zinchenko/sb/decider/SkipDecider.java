package zinchenko.sb.decider;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;


/**
 * Created by zinchenko on 31.08.14.
 */
public class SkipDecider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution,
                                      StepExecution stepExecution) {
        if (stepExecution.getSkipCount() > 0) {
            return new FlowExecutionStatus(
                    "COMPLETED WITH SKIPS"
            );
        } else {
            return new FlowExecutionStatus(
                    jobExecution.getExitStatus().toString()
            );
        }
    }

}
