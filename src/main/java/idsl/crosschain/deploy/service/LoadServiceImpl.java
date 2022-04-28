package idsl.crosschain.deploy.service;

import idsl.crosschain.deploy.contract.Input;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Service
public class LoadServiceImpl implements LoadService{

    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

    public String loadData() {

        String storedValue = "";

        try {
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9032"));  // 192.168.66.73:22000

            Credentials credentials = WalletUtils.loadCredentials("node1", new File("C:/Users/hmnic/blockchain/wallets/wallet1"));
            String address = credentials.getAddress();
//            System.out.println("wallet address: " + address);

            // deploy
//            Input input = Input.deploy(quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT), "initInputData").send();
//            System.out.println("deployed contract address: " + input.getContractAddress());  // 0x9868831d5c4154b70cc2713a9fbd1b59dda7e3bb

            // load
//			Storage storage = Storage.load("0x02cd90b38fe0cda68628aee1d62d3bae51468ce6", quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));
            Input input = Input.load("0x9868831d5c4154b70cc2713a9fbd1b59dda7e3bb", quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));
//            System.out.println("contract address: " + input.getContractAddress());
//			System.out.println(input.greet().send());

//			// data stored
//			storage.store(new BigInteger("100")).send();
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            TransactionReceipt transactionReceipt = input.newGreeting("inputData_" + timestamp).send();
            storedValue = input.greet().send();
            log.info("stored value: {}", storedValue);

//            kafkaTemplate.send("crosschain", storedValue);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return storedValue;
    }

}
