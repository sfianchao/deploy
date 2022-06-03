package idsl.crosschain.deploy.dto.request;

import idsl.crosschain.deploy.model.DataCommon;
import idsl.crosschain.deploy.model.RoutingCommon;
import lombok.Data;

@Data
public class SendRequest {

    public DataCommon dataCommon;

    public RoutingCommon routingCommon;

    public String txStatus;

    public String proof;
}
