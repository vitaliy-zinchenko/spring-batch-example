package zinchenko.sb;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zinchenko on 26.08.14.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/zinchenko/batch-context.xml");
        JobRepository jobRepository = (JobRepository) context.getBean("jobRepository");

        System.out.println("end");
    }
}
