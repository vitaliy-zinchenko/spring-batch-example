package zinchenko.sb.decider;


import oracle.jrockit.jfr.events.JavaEventDescriptor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import zinchenko.sb.FlowExecutionStatusConstants;

import java.io.File;

/**
 * Created by zinchenko on 02.09.14.
 */
public class ExistFileDecider implements JobExecutionDecider {

    private String sourceFile;

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        File file = new File(sourceFile);
        if (file.exists()){
            return FlowExecutionStatusConstants.EXIST;
        } else {
            return
        }
        return file.exists() ? FlowExecutionStatusConstants.EXIST ;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}
