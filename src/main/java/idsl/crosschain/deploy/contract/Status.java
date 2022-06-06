package idsl.crosschain.deploy.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Status extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040518060400160405280600481526020017f696e697400000000000000000000000000000000000000000000000000000000815250600090805190602001906200005f92919062000134565b506040518060400160405280600481526020017f696e69740000000000000000000000000000000000000000000000000000000081525060019080519060200190620000ad92919062000134565b506040518060400160405280600481526020017f696e69740000000000000000000000000000000000000000000000000000000081525060029080519060200190620000fb92919062000134565b506040518060c0016040528060948152602001620011f560949139600390805190602001906200012d92919062000134565b5062000249565b8280546200014290620001e4565b90600052602060002090601f016020900481019282620001665760008555620001b2565b82601f106200018157805160ff1916838001178555620001b2565b82800160010185558215620001b2579182015b82811115620001b157825182559160200191906001019062000194565b5b509050620001c19190620001c5565b5090565b5b80821115620001e0576000816000905550600101620001c6565b5090565b60006002820490506001821680620001fd57607f821691505b602082108114156200021457620002136200021a565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b610f9c80620002596000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80637be1bb1b1161005b5780637be1bb1b14610105578063a324d71014610135578063a68edae814610151578063cb73d72a1461016d57610088565b80630c4dd3741461008d578063179a6a1c146100ab5780631a52e7dd146100c95780632f97d689146100e7575b600080fd5b610095610177565b6040516100a29190610cf8565b60405180910390f35b6100b3610205565b6040516100c09190610cf8565b60405180910390f35b6100d1610293565b6040516100de9190610cf8565b60405180910390f35b6100ef610321565b6040516100fc9190610cf8565b60405180910390f35b61011f600480360381019061011a9190610b9a565b6103af565b60405161012c9190610cf8565b60405180910390f35b61014f600480360381019061014a9190610b9a565b6105fe565b005b61016b60048036038101906101669190610b9a565b610758565b005b6101756108b2565b005b6003805461018490610e2e565b80601f01602080910402602001604051908101604052809291908181526020018280546101b090610e2e565b80156101fd5780601f106101d2576101008083540402835291602001916101fd565b820191906000526020600020905b8154815290600101906020018083116101e057829003601f168201915b505050505081565b6000805461021290610e2e565b80601f016020809104026020016040519081016040528092919081815260200182805461023e90610e2e565b801561028b5780601f106102605761010080835404028352916020019161028b565b820191906000526020600020905b81548152906001019060200180831161026e57829003601f168201915b505050505081565b600280546102a090610e2e565b80601f01602080910402602001604051908101604052809291908181526020018280546102cc90610e2e565b80156103195780601f106102ee57610100808354040283529160200191610319565b820191906000526020600020905b8154815290600101906020018083116102fc57829003601f168201915b505050505081565b6001805461032e90610e2e565b80601f016020809104026020016040519081016040528092919081815260200182805461035a90610e2e565b80156103a75780601f1061037c576101008083540402835291602001916103a7565b820191906000526020600020905b81548152906001019060200180831161038a57829003601f168201915b505050505081565b60606040518060400160405280600381526020017f7372630000000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561048e576000805461040990610e2e565b80601f016020809104026020016040519081016040528092919081815260200182805461043590610e2e565b80156104825780601f1061045757610100808354040283529160200191610482565b820191906000526020600020905b81548152906001019060200180831161046557829003601f168201915b505050505090506105f9565b6040518060400160405280600481526020017f6465737400000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561056b57600180546104e690610e2e565b80601f016020809104026020016040519081016040528092919081815260200182805461051290610e2e565b801561055f5780601f106105345761010080835404028352916020019161055f565b820191906000526020600020905b81548152906001019060200180831161054257829003601f168201915b505050505090506105f9565b6002805461057890610e2e565b80601f01602080910402602001604051908101604052809291908181526020018280546105a490610e2e565b80156105f15780601f106105c6576101008083540402835291602001916105f1565b820191906000526020600020905b8154815290600101906020018083116105d457829003601f168201915b505050505090505b919050565b60006040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525090506040518060400160405280600381526020017f7372630000000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561069f578060009080519060200190610699929190610a87565b5061071f565b6040518060400160405280600481526020017f64657374000000000000000000000000000000000000000000000000000000008152508051906020012082805190602001201415610706578060019080519060200190610700929190610a87565b5061071e565b806002908051906020019061071c929190610a87565b505b5b7f7d2211d63bbbbeea171c05f703e2748272ed0f62af7970a1f95da2fbeec3402360405161074c90610d1a565b60405180910390a15050565b60006040518060400160405280600781526020017f707265706172650000000000000000000000000000000000000000000000000081525090506040518060400160405280600381526020017f737263000000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156107f95780600090805190602001906107f3929190610a87565b50610879565b6040518060400160405280600481526020017f6465737400000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561086057806001908051906020019061085a929190610a87565b50610878565b8060029080519060200190610876929190610a87565b505b5b7f7d2211d63bbbbeea171c05f703e2748272ed0f62af7970a1f95da2fbeec340236040516108a690610d3a565b60405180910390a15050565b6040518060400160405280600781526020017f70726570617265000000000000000000000000000000000000000000000000008152508051906020012060006040516108fe9190610ce1565b604051809103902014801561096457506040518060400160405280600781526020017f707265706172650000000000000000000000000000000000000000000000000081525080519060200120600160405161095a9190610ce1565b6040518091039020145b801561099b5750600160405161097a9190610ce1565b604051809103902060006040516109919190610ce1565b6040518091039020145b15610a85576040518060400160405280600681526020017f636f6d6d69740000000000000000000000000000000000000000000000000000815250600090805190602001906109eb929190610a87565b506040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525060019080519060200190610a37929190610a87565b506040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525060029080519060200190610a83929190610a87565b505b565b828054610a9390610e2e565b90600052602060002090601f016020900481019282610ab55760008555610afc565b82601f10610ace57805160ff1916838001178555610afc565b82800160010185558215610afc579182015b82811115610afb578251825591602001919060010190610ae0565b5b509050610b099190610b0d565b5090565b5b80821115610b26576000816000905550600101610b0e565b5090565b6000610b3d610b3884610d7f565b610d5a565b905082815260208101848484011115610b5957610b58610ef4565b5b610b64848285610dec565b509392505050565b600082601f830112610b8157610b80610eef565b5b8135610b91848260208601610b2a565b91505092915050565b600060208284031215610bb057610baf610efe565b5b600082013567ffffffffffffffff811115610bce57610bcd610ef9565b5b610bda84828501610b6c565b91505092915050565b60008154610bf081610e2e565b610bfa8186610dd0565b94506001821660008114610c155760018114610c2657610c59565b60ff19831686528186019350610c59565b610c2f85610db0565b60005b83811015610c5157815481890152600182019150602081019050610c32565b838801955050505b50505092915050565b6000610c6d82610dc5565b610c778185610ddb565b9350610c87818560208601610dfb565b610c9081610f03565b840191505092915050565b6000610ca8601483610ddb565b9150610cb382610f14565b602082019050919050565b6000610ccb601583610ddb565b9150610cd682610f3d565b602082019050919050565b6000610ced8284610be3565b915081905092915050565b60006020820190508181036000830152610d128184610c62565b905092915050565b60006020820190508181036000830152610d3381610c9b565b9050919050565b60006020820190508181036000830152610d5381610cbe565b9050919050565b6000610d64610d75565b9050610d708282610e60565b919050565b6000604051905090565b600067ffffffffffffffff821115610d9a57610d99610ec0565b5b610da382610f03565b9050602081019050919050565b60008190508160005260206000209050919050565b600081519050919050565b600081905092915050565b600082825260208201905092915050565b82818337600083830152505050565b60005b83811015610e19578082015181840152602081019050610dfe565b83811115610e28576000848401525b50505050565b60006002820490506001821680610e4657607f821691505b60208210811415610e5a57610e59610e91565b5b50919050565b610e6982610f03565b810181811067ffffffffffffffff82111715610e8857610e87610ec0565b5b80604052505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f7365742073746174757320746f20636f6d6d6974000000000000000000000000600082015250565b7f7365742073746174757320746f2070726570617265000000000000000000000060008201525056fea2646970667358221220995a272ef6a6ec7898c5c25008c616f3dfbd4740b9eabd30ac42b15b4ae95d5d64736f6c634300080700332264617461436f6d6d6f6e223a7b22736f75726365223a7b226e6f64654964223a22222c22636861696e4964223a22227d2c2264657374696e6174696f6e223a7b226e6f64654964223a22222c22636861696e4964223a22227d2c22747854797065223a22222c227478436f6e74656e74223a22222c2274696d655374616d70223a22222c227369676e6174757265223a22227d";

    public static final String FUNC_CHECKTXSTATUS = "checkTxStatus";

    public static final String FUNC_DATACOMMONFORMAT = "dataCommonFormat";

    public static final String FUNC_GETCURRENTSTATUS = "getCurrentStatus";

    public static final String FUNC_SETSTATUSTOCOMMIT = "setStatusToCommit";

    public static final String FUNC_SETSTATUSTOPREPARE = "setStatusToPrepare";

    public static final String FUNC_STATUSA = "statusA";

    public static final String FUNC_STATUSB = "statusB";

    public static final String FUNC_STATUSRELAY = "statusRelay";

    public static final Event CHECKSTATUS_EVENT = new Event("checkStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event SETSTATUS_EVENT = new Event("setStatus", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected Status(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Status(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Status(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Status(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<CheckStatusEventResponse> getCheckStatusEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(CHECKSTATUS_EVENT, transactionReceipt);
        ArrayList<CheckStatusEventResponse> responses = new ArrayList<CheckStatusEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            CheckStatusEventResponse typedResponse = new CheckStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.status = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CheckStatusEventResponse> checkStatusEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CheckStatusEventResponse>() {
            @Override
            public CheckStatusEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(CHECKSTATUS_EVENT, log);
                CheckStatusEventResponse typedResponse = new CheckStatusEventResponse();
                typedResponse.log = log;
                typedResponse.status = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CheckStatusEventResponse> checkStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHECKSTATUS_EVENT));
        return checkStatusEventFlowable(filter);
    }

    public List<SetStatusEventResponse> getSetStatusEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(SETSTATUS_EVENT, transactionReceipt);
        ArrayList<SetStatusEventResponse> responses = new ArrayList<SetStatusEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            SetStatusEventResponse typedResponse = new SetStatusEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.status = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SetStatusEventResponse> setStatusEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SetStatusEventResponse>() {
            @Override
            public SetStatusEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(SETSTATUS_EVENT, log);
                SetStatusEventResponse typedResponse = new SetStatusEventResponse();
                typedResponse.log = log;
                typedResponse.status = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SetStatusEventResponse> setStatusEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETSTATUS_EVENT));
        return setStatusEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> checkTxStatus() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHECKTXSTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> dataCommonFormat() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DATACOMMONFORMAT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getCurrentStatus(String _chainName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCURRENTSTATUS, 
                Arrays.<Type>asList(new Utf8String(_chainName)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setStatusToCommit(String _chainName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTATUSTOCOMMIT, 
                Arrays.<Type>asList(new Utf8String(_chainName)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setStatusToPrepare(String _chainName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTATUSTOPREPARE, 
                Arrays.<Type>asList(new Utf8String(_chainName)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> statusA() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STATUSA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> statusB() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STATUSB, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> statusRelay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STATUSRELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Status load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Status(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Status load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Status(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Status load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Status(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Status load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Status(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Status> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Status.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Status> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Status.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Status> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Status.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Status> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Status.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CheckStatusEventResponse extends BaseEventResponse {
        public String status;
    }

    public static class SetStatusEventResponse extends BaseEventResponse {
        public String status;
    }
}
