package idsl.crosschain.deploy.service;

import idsl.crosschain.deploy.dto.request.LaunchTxRequest;
import idsl.crosschain.deploy.dto.response.LaunchTxResponse;

public interface TransactionService {

    LaunchTxResponse launchTx(LaunchTxRequest launchTxRequest);
}
