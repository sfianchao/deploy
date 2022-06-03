package idsl.crosschain.deploy.dto.request;

import lombok.Data;

@Data
public class NotifyRequest {

    public NotifyRequest() {

    }

    public NotifyRequest(String txId, String chainName, String txStatus, String proof) {
        this.txId = txId;
        this.chainName = chainName;
        this.txStatus = txStatus;
        this.proof = proof;
    }

    public String txId;

    public String chainName;

    public String txStatus;

    public String proof;
}
