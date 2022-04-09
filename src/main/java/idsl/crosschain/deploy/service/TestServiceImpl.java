package idsl.crosschain.deploy.service;

import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;

@Service
public class TestServiceImpl implements TestService{

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


}
