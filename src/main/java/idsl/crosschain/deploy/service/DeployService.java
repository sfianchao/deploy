package idsl.crosschain.deploy.service;

import com.alibaba.fastjson2.JSONObject;

public interface DeployService {

    JSONObject deployContract(String chainName);
}
