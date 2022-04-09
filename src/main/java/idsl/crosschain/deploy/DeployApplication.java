package idsl.crosschain.deploy;

import idsl.crosschain.deploy.contract.Storage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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

		System.out.println("hello spring");

//		try {
//			Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9032"));  // 192.168.66.73:22000
//			Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//			String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//			System.out.println(clientVersion);
//
//			Credentials credentials = WalletUtils.loadCredentials("node1", new File("C:/Users/hmnic/blockchain/wallets/wallet1"));
//			String address = credentials.getAddress();
//			System.out.println("contract address: " + address);
//
//			// deploy
////            Storage storage = Storage.deploy(quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT)).send();
////            System.out.println("deployed contract address: " + storage.getContractAddress());
//
//			// load
//			Storage storage = Storage.load("0xd02c4e8c08b3faebe09af03a50fc82476cad1558", quorum, credentials, new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));
//
//			// data stored
//			storage.store(new BigInteger("100")).send();
//
//			// data retrieve
//			BigInteger value = storage.retrieve().send();
//			System.out.println(value.toString());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
