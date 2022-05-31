package idsl.crosschain.deploy.model;

import lombok.Data;
import org.web3j.crypto.Credentials;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.StaticGasProvider;

@Data
public class QuorumInfo {

    private Quorum quorum;

    private Credentials credentials;

    private StaticGasProvider gasProvider;

}
