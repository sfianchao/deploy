package idsl.crosschain.deploy;

import idsl.crosschain.deploy.contract.Input;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.math.BigInteger;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class DeployApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);

        try {
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9032"));  // 192.168.66.73:22000
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println(clientVersion);

            Credentials credentials = WalletUtils.loadCredentials("node1", new File("C:/Users/hmnic/blockchain/wallets/wallet1"));
            String address = credentials.getAddress();
            System.out.println("wallet address: " + address);

            // deploy
//            Input input = Input.deploy(quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT), "initInputData").send();
//            System.out.println("deployed contract address: " + input.getContractAddress());  // 0x9868831d5c4154b70cc2713a9fbd1b59dda7e3bb

            // load
//			Storage storage = Storage.load("0x02cd90b38fe0cda68628aee1d62d3bae51468ce6", quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));
            Input input = Input.load("0x9868831d5c4154b70cc2713a9fbd1b59dda7e3bb", quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));
            System.out.println("contract address: " + input.getContractAddress());
//			System.out.println(input.greet().send());

//			// data stored
//			storage.store(new BigInteger("100")).send();
//			LocalDateTime now = LocalDateTime.now();
//			TransactionReceipt transactionReceipt = input.newGreeting("inputData_" + now).send();
//			System.out.println(input.greet().send());

//			// data retrieve
//			BigInteger value = storage.retrieve().send();
//			System.out.println(value.toString());
//
//			// block listen
//			EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, "0x9868831d5c4154b70cc2713a9fbd1b59dda7e3bb");
//			input.modifiedEventFlowable(filter).subscribe(log -> System.out.println(log.newGreeting));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
