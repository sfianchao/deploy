package idsl.crosschain.deploy.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;

@Data
public class DataCommon {

    private NodeInfo source;

    private NodeInfo destination;

    private String txType;

    private String txContent;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Timestamp timeStamp;

    private String signature;
}
