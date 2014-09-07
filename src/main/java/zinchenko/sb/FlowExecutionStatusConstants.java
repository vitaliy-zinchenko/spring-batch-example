package zinchenko.sb;

import org.springframework.batch.core.job.flow.FlowExecutionStatus;

/**
 * Created by zinchenko on 02.09.14.
 */
public interface FlowExecutionStatusConstants {

    public static final FlowExecutionStatus EXIST = new FlowExecutionStatus("EXIST");

    public static final FlowExecutionStatus NO_EXIST = new FlowExecutionStatus("NO_EXIST");

}
