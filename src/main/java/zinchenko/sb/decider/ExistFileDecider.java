package zinchenko.sb.decider;


import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import zinchenko.sb.FlowExecutionStatusConstants;
import zinchenko.sb.JobParametersConstants;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by zinchenko on 02.09.14.
 */
public class ExistFileDecider implements JobExecutionDecider, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        try {
            String sourceFile = jobExecution.getJobParameters().getString(JobParametersConstants.SOURCE_FILE);
            Resource resource = resourceLoader.getResource(sourceFile);
            return resource.getFile().exists() ? FlowExecutionStatusConstants.EXIST : FlowExecutionStatusConstants.NO_EXIST;
        } catch (IOException e) {
            throw new RuntimeException("Fail during file exist deciding", e);
        }
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
