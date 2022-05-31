package idsl.crosschain.deploy.config;

import idsl.crosschain.deploy.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
public class QuorumConfig {

    @Bean(name = "quorumBuilder")
    public QuorumInfo quorumBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9055"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("9bc3dd5c1655b543964fb6b531a6b9e139045d268118f94c9da5b38162016db7");
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
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9032"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("source chain client version: " + clientVersion);

            // set up credentials
            Credentials credentials = WalletUtils.loadCredentials("node1", new File("./wallets/wallet1"));
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT);
            log.info("source chain account address: " + credentials.getAddress());

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
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("relay chain client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("c6d9fdfa45dcf9ba7522c56c9b7d65d039f2a1cc997342f616995ae2c125878d");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("relay chain account address: " + credentials.getAddress());

            // [2022/05/26 07:13:24] deployed contract address: 0x8f2a4481aba0e2c888d5c423c54500b482b251d9

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
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9055"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("destination chain client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("6d2d3f7109e625f552561a50c22fa37044349e9a85970de8715c177422c3a93e");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("destination chain account address: " + credentials.getAddress());

            // [2022/05/26 10:10:33] deployed contract address: 0x35d50a57b9fb47ab568f999473a72d9223ed005b

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }
}
