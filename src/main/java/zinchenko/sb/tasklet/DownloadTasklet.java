package zinchenko.sb.tasklet;

import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * Created by zinchenko on 02.09.14.
 */
public class DownloadTasklet implements Tasklet {

    private Resource fileSource;

    private Resource fileDestination;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        OutputStream outputStream = new FileOutputStream(fileDestination.getFile());
        IOUtils.copy(fileSource.getInputStream(), outputStream);
        return RepeatStatus.FINISHED;
    }

    public void setFileSource(Resource fileSource) {
        this.fileSource = fileSource;
    }

    public void setFileDestination(Resource fileDestination) {
        this.fileDestination = fileDestination;
    }
}
