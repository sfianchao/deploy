package idsl.crosschain.deploy.model;

import lombok.Data;

@Data
public class BridgeNode {

    public BridgeNode() {
    }

    public BridgeNode(String nodeId, String chainName, String ip, String pk) {
        this.nodeId = nodeId;
        this.chainName = chainName;
        this.ip = ip;
        this.pk = pk;
    }

    private String nodeId;

    private String chainName;

    private String ip;

    private String pk;
}
