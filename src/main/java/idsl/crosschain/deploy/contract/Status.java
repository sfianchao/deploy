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
    public static final String BINARY = "60806040523480156200001157600080fd5b506040518060400160405280600481526020017f696e697400000000000000000000000000000000000000000000000000000000815250600090805190602001906200005f92919062000102565b506040518060400160405280600481526020017f696e69740000000000000000000000000000000000000000000000000000000081525060019080519060200190620000ad92919062000102565b506040518060400160405280600481526020017f696e69740000000000000000000000000000000000000000000000000000000081525060029080519060200190620000fb92919062000102565b5062000217565b8280546200011090620001b2565b90600052602060002090601f01602090048101928262000134576000855562000180565b82601f106200014f57805160ff191683800117855562000180565b8280016001018555821562000180579182015b828111156200017f57825182559160200191906001019062000162565b5b5090506200018f919062000193565b5090565b5b80821115620001ae57600081600090555060010162000194565b5090565b60006002820490506001821680620001cb57607f821691505b60208210811415620001e257620001e1620001e8565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b610df080620002276000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80637be1bb1b1161005b5780637be1bb1b146100dc578063a324d7101461010c578063a68edae814610128578063cb73d72a146101445761007d565b8063179a6a1c146100825780631a52e7dd146100a05780632f97d689146100be575b600080fd5b61008a61014e565b6040516100979190610b4c565b60405180910390f35b6100a86101dc565b6040516100b59190610b4c565b60405180910390f35b6100c661026a565b6040516100d39190610b4c565b60405180910390f35b6100f660048036038101906100f191906109ee565b6102f8565b6040516101039190610b4c565b60405180910390f35b610126600480360381019061012191906109ee565b610547565b005b610142600480360381019061013d91906109ee565b6106a1565b005b61014c6107fb565b005b6000805461015b90610c82565b80601f016020809104026020016040519081016040528092919081815260200182805461018790610c82565b80156101d45780601f106101a9576101008083540402835291602001916101d4565b820191906000526020600020905b8154815290600101906020018083116101b757829003601f168201915b505050505081565b600280546101e990610c82565b80601f016020809104026020016040519081016040528092919081815260200182805461021590610c82565b80156102625780601f1061023757610100808354040283529160200191610262565b820191906000526020600020905b81548152906001019060200180831161024557829003601f168201915b505050505081565b6001805461027790610c82565b80601f01602080910402602001604051908101604052809291908181526020018280546102a390610c82565b80156102f05780601f106102c5576101008083540402835291602001916102f0565b820191906000526020600020905b8154815290600101906020018083116102d357829003601f168201915b505050505081565b60606040518060400160405280600181526020017f410000000000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156103d7576000805461035290610c82565b80601f016020809104026020016040519081016040528092919081815260200182805461037e90610c82565b80156103cb5780601f106103a0576101008083540402835291602001916103cb565b820191906000526020600020905b8154815290600101906020018083116103ae57829003601f168201915b50505050509050610542565b6040518060400160405280600181526020017f420000000000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156104b4576001805461042f90610c82565b80601f016020809104026020016040519081016040528092919081815260200182805461045b90610c82565b80156104a85780601f1061047d576101008083540402835291602001916104a8565b820191906000526020600020905b81548152906001019060200180831161048b57829003601f168201915b50505050509050610542565b600280546104c190610c82565b80601f01602080910402602001604051908101604052809291908181526020018280546104ed90610c82565b801561053a5780601f1061050f5761010080835404028352916020019161053a565b820191906000526020600020905b81548152906001019060200180831161051d57829003601f168201915b505050505090505b919050565b60006040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525090506040518060400160405280600181526020017f410000000000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156105e85780600090805190602001906105e29291906108db565b50610668565b6040518060400160405280600181526020017f4200000000000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561064f5780600190805190602001906106499291906108db565b50610667565b80600290805190602001906106659291906108db565b505b5b7f7d2211d63bbbbeea171c05f703e2748272ed0f62af7970a1f95da2fbeec3402360405161069590610b6e565b60405180910390a15050565b60006040518060400160405280600781526020017f707265706172650000000000000000000000000000000000000000000000000081525090506040518060400160405280600181526020017f4100000000000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561074257806000908051906020019061073c9291906108db565b506107c2565b6040518060400160405280600181526020017f420000000000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156107a95780600190805190602001906107a39291906108db565b506107c1565b80600290805190602001906107bf9291906108db565b505b5b7f7d2211d63bbbbeea171c05f703e2748272ed0f62af7970a1f95da2fbeec340236040516107ef90610b8e565b60405180910390a15050565b6040518060400160405280600781526020017f70726570617265000000000000000000000000000000000000000000000000008152508051906020012060006040516108479190610b35565b6040518091039020148015610887575060016040516108669190610b35565b6040518091039020600060405161087d9190610b35565b6040518091039020145b156108d9576040518060400160405280600681526020017f636f6d6d69740000000000000000000000000000000000000000000000000000815250600290805190602001906108d79291906108db565b505b565b8280546108e790610c82565b90600052602060002090601f0160209004810192826109095760008555610950565b82601f1061092257805160ff1916838001178555610950565b82800160010185558215610950579182015b8281111561094f578251825591602001919060010190610934565b5b50905061095d9190610961565b5090565b5b8082111561097a576000816000905550600101610962565b5090565b600061099161098c84610bd3565b610bae565b9050828152602081018484840111156109ad576109ac610d48565b5b6109b8848285610c40565b509392505050565b600082601f8301126109d5576109d4610d43565b5b81356109e584826020860161097e565b91505092915050565b600060208284031215610a0457610a03610d52565b5b600082013567ffffffffffffffff811115610a2257610a21610d4d565b5b610a2e848285016109c0565b91505092915050565b60008154610a4481610c82565b610a4e8186610c24565b94506001821660008114610a695760018114610a7a57610aad565b60ff19831686528186019350610aad565b610a8385610c04565b60005b83811015610aa557815481890152600182019150602081019050610a86565b838801955050505b50505092915050565b6000610ac182610c19565b610acb8185610c2f565b9350610adb818560208601610c4f565b610ae481610d57565b840191505092915050565b6000610afc601483610c2f565b9150610b0782610d68565b602082019050919050565b6000610b1f601583610c2f565b9150610b2a82610d91565b602082019050919050565b6000610b418284610a37565b915081905092915050565b60006020820190508181036000830152610b668184610ab6565b905092915050565b60006020820190508181036000830152610b8781610aef565b9050919050565b60006020820190508181036000830152610ba781610b12565b9050919050565b6000610bb8610bc9565b9050610bc48282610cb4565b919050565b6000604051905090565b600067ffffffffffffffff821115610bee57610bed610d14565b5b610bf782610d57565b9050602081019050919050565b60008190508160005260206000209050919050565b600081519050919050565b600081905092915050565b600082825260208201905092915050565b82818337600083830152505050565b60005b83811015610c6d578082015181840152602081019050610c52565b83811115610c7c576000848401525b50505050565b60006002820490506001821680610c9a57607f821691505b60208210811415610cae57610cad610ce5565b5b50919050565b610cbd82610d57565b810181811067ffffffffffffffff82111715610cdc57610cdb610d14565b5b80604052505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f7365742073746174757320746f20636f6d6d6974000000000000000000000000600082015250565b7f7365742073746174757320746f2070726570617265000000000000000000000060008201525056fea26469706673582212201ad1cfbf88a5ae0eeba2d6f035f48759acd1ba676077a5ab261164009d89e35464736f6c63430008070033";

    public static final String FUNC_CHECKTXSTATUS = "checkTxStatus";

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
