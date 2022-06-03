package idsl.crosschain.deploy.model;

import lombok.Data;

@Data
public class NodeInfo {

    public NodeInfo() {

    }

    public NodeInfo(String nodeId, String chainName) {
        this.nodeId = nodeId;
        this.chainName = chainName;
    }

    private String nodeId = "NULL";

    private String chainName = "NULL";
}
