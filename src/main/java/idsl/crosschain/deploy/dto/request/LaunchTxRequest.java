package idsl.crosschain.deploy.dto.request;

import idsl.crosschain.deploy.model.BridgeNode;
import lombok.Data;

@Data
public class LaunchTxRequest {

    private BridgeNode source;

    private BridgeNode destination;

    private String txType;

    private String txContent;
}
