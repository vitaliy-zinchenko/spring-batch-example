package zinchenko.sb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zinchenko on 26.08.14.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/zinchenko/sb-job-context.xml");
        JobRepository jobRepository = (JobRepository) context.getBean("jobRepository");

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("importInvoicesJob");

        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("sourceFile", "D:\\projects\\spring-batch-example\\src\\main\\resources\\zinchenko\\file_x.csv")
                    .addString("fileDestination", "D:\\projects\\spring-batch-example\\src\\main\\resources\\zinchenko\\file_y.csv")
                    .toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}
