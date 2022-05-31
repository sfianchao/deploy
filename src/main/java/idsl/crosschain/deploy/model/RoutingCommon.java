package idsl.crosschain.deploy.model;

import lombok.Data;

@Data
public class RoutingCommon {

    private BridgeNode from;

    private BridgeNode to;

    private BridgeNode relayBridge;

    private String timeStamp;

    private String signature;
}
