package idsl.crosschain.deploy.config;

import idsl.crosschain.deploy.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Slf4j
@Configuration
public class QuorumConfig {

//    <<localhost>>
//    --------------------------------------------------------------------------------------------------------------------

//    @Bean(name = "sourceChainBuilder")
//    public QuorumInfo sourceChainBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://192.168.47.129:22000"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[src] chain client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = WalletUtils.loadCredentials("node", new File("C:/Users/hmnic/Documents/GitHub/web3jTest/wallets-src/wallet1"));
//            StaticGasProvider gasProvider = new StaticGasProvider(DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
//            log.info("[src] account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }
//
//    @Bean(name = "relayChainBuilder")
//    public QuorumInfo relayChainBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://192.168.47.130:22000"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[relay] chain client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = WalletUtils.loadCredentials("node", new File("C:/Users/hmnic/Documents/GitHub/web3jTest/wallets-relay/wallet1"));
//            StaticGasProvider gasProvider = new StaticGasProvider(DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
//            log.info("[relay] account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }
//
//    @Bean(name = "destinationChainBuilder")
//    public QuorumInfo destinationChainBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://192.168.47.128:22000"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[dest] chain client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = WalletUtils.loadCredentials("node", new File("C:/Users/hmnic/Documents/GitHub/web3jTest/wallets-dest/wallet1"));
//            StaticGasProvider gasProvider = new StaticGasProvider(DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
//            log.info("[dest] account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }


//    <<總計劃>>
//    --------------------------------------------------------------------------------------------------------------------

//    @Bean(name = "quorumBuilder")
//    public QuorumInfo quorumBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = Credentials.create("ba394d6ecde04efb7bce0001f130d878794d890b9da8a27eb950a4b6aa58dd76");
//            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
//            log.info("account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }
//
//    @Bean(name = "sourceChainBuilder")
//    public QuorumInfo sourceChainBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9035"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[src chain] client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = WalletUtils.loadCredentials("node1", new File("./wallets/wallet1"));
//            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT);
//            log.info("[src chain] account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }
//
//    @Bean(name = "relayChainBuilder")
//    public QuorumInfo relayChainBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[relay chain] client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = Credentials.create("ba394d6ecde04efb7bce0001f130d878794d890b9da8a27eb950a4b6aa58dd76");
//            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
//            log.info("[relay chain] account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }
//
//    @Bean(name = "destinationChainBuilder")
//    public QuorumInfo destinationChainBuilder() {
//
//        QuorumInfo quorumInfo = new QuorumInfo();
//
//        try {
//            // connect to blockchain
//            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9055"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[dest chain] client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = Credentials.create("4db25a3a7b7953809d61fca3d3ae13b2fc1498d5d246e93e4e8d959aef52f508");
//            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
//            log.info("[dest chain] account address: " + credentials.getAddress());
//
//            quorumInfo.setQuorum(quorum);
//            quorumInfo.setCredentials(credentials);
//            quorumInfo.setGasProvider(gasProvider);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return quorumInfo;
//    }

//    <<idsl>>
//    --------------------------------------------------------------------------------------------------------------------

    @Bean(name = "quorumBuilder")
    public QuorumInfo quorumBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService("http://192.168.66.74:8545"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("ba394d6ecde04efb7bce0001f130d878794d890b9da8a27eb950a4b6aa58dd76");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("account address: " + credentials.getAddress());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }

    @Bean(name = "sourceChainBuilder")
    public QuorumInfo sourceChainBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService("http://192.168.66.73:8545"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("[src chain] client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("812d049c2ebb6678173680b6b77c1e79a3522709a2c9a5c051f6a3364e4b3698");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("[src chain] account address: " + credentials.getAddress());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }

    @Bean(name = "relayChainBuilder")
    public QuorumInfo relayChainBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService("http://192.168.66.74:8545"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("[relay chain] client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("ba394d6ecde04efb7bce0001f130d878794d890b9da8a27eb950a4b6aa58dd76");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("[relay chain] account address: " + credentials.getAddress());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }

    @Bean(name = "destinationChainBuilder")
    public QuorumInfo destinationChainBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService("http://192.168.66.75:8545"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("[dest chain] client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("4db25a3a7b7953809d61fca3d3ae13b2fc1498d5d246e93e4e8d959aef52f508");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("[dest chain] account address: " + credentials.getAddress());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }

}
