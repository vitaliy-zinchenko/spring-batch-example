package zinchenko.sb;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zinchenko on 02.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:zinchenko/sb/sb-infrastructure-context.xml",
        "classpath:zinchenko/sb/sb-job-context.xml",
        "classpath:zinchenko/sb/db-context.xml"})
//@DatabaseSetup("classpath:zinchenko/dataset.xml")
//@TestExecutionListeners({DbUnitTestExecutionListener.class})
public class JobTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Autowired
    ApplicationContext applicationContext;

    @Before
    public void before() {
    }

    private void launch(String sourceFile, String fileDestination) throws Exception {
        JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
        Job job = (Job) applicationContext.getBean("importInvoicesJob");

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("sourceFile", sourceFile)
                .addString("fileDestination", fileDestination)
                .toJobParameters();
        JobExecution execution = jobLauncher.run(job, jobParameters);
    }

    private String getPathOfResource(String resource) {
        return getClass().getClassLoader().getResource(resource).getPath();
    }

    @Test
    public void testDelete() throws Exception {
        String sourceFile = "file:" + getPathOfResource("file_x.csv");
        String fileDestination = "file:" + temporaryFolder.newFile("destination.csv").getPath();
        launch(sourceFile, fileDestination);
        System.out.println("test");
    }

}
