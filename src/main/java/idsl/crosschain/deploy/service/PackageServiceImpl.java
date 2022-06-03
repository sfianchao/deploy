package idsl.crosschain.deploy.service;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import idsl.crosschain.deploy.model.DataCommon;
import idsl.crosschain.deploy.model.NodeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PackageServiceImpl implements PackageService {

    @Override
    public JSONObject getDataCommonFormat() {

        DataCommon dataCommon = new DataCommon();
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.setNodeId("null");
        nodeInfo.setChainName("null");
        dataCommon.setSource(nodeInfo);
        dataCommon.setDestination(nodeInfo);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataCommon);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", jsonStr != null ? jsonStr : "unknown");

        return jsonObject;
    }
}
