package idsl.crosschain.deploy.service;

import idsl.crosschain.deploy.contract.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.math.BigInteger;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    public String testConnection() {

        String clientVersion = "";

        try {
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9032"));  // 192.168.66.73:22000
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println(clientVersion);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientVersion;
    }

    public String loadData() {

        BigInteger value = BigInteger.ZERO;

        try {
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9032"));  // 192.168.66.73:22000
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            System.out.println(clientVersion);
            Credentials credentials = WalletUtils.loadCredentials("node1", new File("./wallets/wallet1"));
            String address = credentials.getAddress();
            System.out.println("wallet address: " + address);

//            Storage storage = Storage.deploy(quorum, credentials,
//                    new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT)).send();
//            storage.store(new BigInteger("100")).send();
//            System.out.println("contract address: " + storage.getContractAddress());

            Storage storage = Storage.load("0x4bb6086bcf8a7ad61c19fbd2c4245fcd2e0ae914", quorum, credentials,
                    new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));
            storage.store(new BigInteger("10000")).send();

            value = storage.retrieve().send();
            System.out.println(value.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value.toString();
    }

}
