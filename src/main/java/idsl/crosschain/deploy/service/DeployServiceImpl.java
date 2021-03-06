package idsl.crosschain.deploy.service;

import com.alibaba.fastjson2.JSONObject;
import idsl.crosschain.deploy.util.StatusContractUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeployServiceImpl implements DeployService {

    @Autowired
    private StatusContractUtil statusContractUtil;


    @Override
    public JSONObject deployContract(String chainName) {
        String chain = chainBuilderSelector(chainName);
        return statusContractUtil.deploy(chain);
    }

    private String chainBuilderSelector(String chainName) {
        if (chainName.equalsIgnoreCase("src")) {
            return "sourceChainBuilder";
        } else if (chainName.equalsIgnoreCase("dest")) {
            return "destinationChainBuilder";
        } else if (chainName.equalsIgnoreCase("relay")) {
            return "relayChainBuilder";
        } else {
            return null;
        }
    }
}
