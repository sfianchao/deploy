package idsl.crosschain.deploy.service;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import idsl.crosschain.deploy.contract.TxStatus;
import idsl.crosschain.deploy.dto.request.LaunchTxRequest;
import idsl.crosschain.deploy.dto.request.NotifyRequest;
import idsl.crosschain.deploy.dto.request.SendRequest;
import idsl.crosschain.deploy.dto.response.LaunchTxResponse;
import idsl.crosschain.deploy.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public TransactionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public LaunchTxResponse launchTx(LaunchTxRequest launchTxRequest) {

        String srcChainName = launchTxRequest.getSource().getChainName();
        String destChainName = launchTxRequest.getDestination().getChainName();
        log.info("1. Launch tx from [{}] to [{}]", srcChainName, destChainName);

        // get src chain bridgeNode
        String src_url = "http://localhost:8081/bridge-node/get/" + srcChainName;
        RoutingInfo srcRoutingInfo = restTemplate.getForObject(src_url, RoutingInfo.class);
        log.info("src chain info: {}", srcRoutingInfo);

        // get relay chain bridgeNode
        String relay_url = "http://localhost:8081/bridge-node/get/Relay";
        RoutingInfo relayRoutingInfo = restTemplate.getForObject(relay_url, RoutingInfo.class);
        log.info("relay chain info: {}", relayRoutingInfo);

        // get dest chain bridgeNode
        String url = "http://localhost:8081/bridge-node/get/" + destChainName;
        RoutingInfo destRoutingInfo = restTemplate.getForObject(url, RoutingInfo.class);
        log.info("dest chain info: {}", destRoutingInfo);

        // setup routingCommon
        RoutingCommon routingCommon = setupRoutingCommon(srcRoutingInfo, relayRoutingInfo, destRoutingInfo);
        log.info("routingCommon: {}", routingCommon);

        // setup dataCommon
        DataCommon dataCommon = setupDataCommon(launchTxRequest, srcRoutingInfo, destRoutingInfo);
        log.info("dataCommon: {}", dataCommon);

        // set src tx status to "prepare"
        String src_tx_url = "http://localhost:8082/contract/status/set/" + srcChainName + "/" + TxStatus.prepare;
        JSONObject srcTxStatus = restTemplate.postForObject(src_tx_url, null, JSONObject.class);
        log.info("2. src tx status: {}", srcTxStatus.get("msg"));

        // send tx to dest chain
        String send_url = "http://localhost:8082/transfer/send";
        SendRequest sendRequest = new SendRequest();
        sendRequest.setDataCommon(dataCommon);
        sendRequest.setRoutingCommon(routingCommon);
        sendRequest.setTxStatus("prepare");
        sendRequest.setProof("proof");
        JSONObject sendRes = restTemplate.postForObject(send_url, sendRequest, JSONObject.class);
        log.info("3. send response: {}", sendRes.get("msg"));

        // notify status to relay chain to "prepare"
        NotifyRequest notifyRequest = new NotifyRequest("txId", srcChainName, TxStatus.prepare.toString(), "proof");
        String notify_relay_url = "http://localhost:8082/transfer/status/notify";
        JSONObject relayTxStatus = restTemplate.postForObject(notify_relay_url, notifyRequest, JSONObject.class);
        log.info("4. [relay] {} tx status: {}", srcChainName, relayTxStatus.getString("msg"));

        // check relay chain tx status
        String check_relay_url = "http://localhost:8082/sync/status/check";
        JSONObject checkRes = restTemplate.postForObject(check_relay_url, null, JSONObject.class);
        log.info("5. [relay] check tx status: {}", checkRes.getString("msg"));

        // get relay tx status
        String relay_tx_url = "http://localhost:8082/sync/relay/status/Relay";
        JSONObject relayRes = restTemplate.getForObject(relay_tx_url, JSONObject.class);
        log.info("6. [relay] final tx status: {}", relayRes.getString("txStatus"));

        LaunchTxResponse launchTxResponse = new LaunchTxResponse();
        launchTxResponse.setTxType("Res");
        if (relayRes.getString("txStatus").equals("commit")) {
            launchTxResponse.setTxContent(sendRes.getString("msg"));
        } else {
            launchTxResponse.setTxContent("tx failed");
        }
        return launchTxResponse;
    }

    private DataCommon setupDataCommon(LaunchTxRequest launchTxRequest, RoutingInfo srcRoutingInfo, RoutingInfo destRoutingInfo) {

        DataCommon dataCommon = new DataCommon();
        dataCommon.setSource(new NodeInfo(srcRoutingInfo.getId(), srcRoutingInfo.getChainName()));
        dataCommon.setDestination(new NodeInfo(destRoutingInfo.getId(), destRoutingInfo.getChainName()));
        dataCommon.setTxType(launchTxRequest.getTxType());
        dataCommon.setTxContent(launchTxRequest.getTxContent());
        dataCommon.setSignature("null");
        dataCommon.setTimeStamp("null");
        return dataCommon;
    }

    private RoutingCommon setupRoutingCommon(RoutingInfo srcRoutingInfo, RoutingInfo relayRoutingInfo, RoutingInfo destRoutingInfo) {

        RoutingCommon routingCommon = new RoutingCommon();
        routingCommon.setFrom(new BridgeNode(srcRoutingInfo.getId(), srcRoutingInfo.getChainName(), srcRoutingInfo.getIp(), null));
        routingCommon.setTo(new BridgeNode(destRoutingInfo.getId(), destRoutingInfo.getChainName(), destRoutingInfo.getIp(), null));
        routingCommon.setRelayBridge(new BridgeNode(relayRoutingInfo.getId(), relayRoutingInfo.getChainName(), relayRoutingInfo.getIp(), null));

        return routingCommon;
    }

}
