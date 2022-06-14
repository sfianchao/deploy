package idsl.crosschain.deploy.contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
    public static final String BINARY = "60806040523480156200001157600080fd5b50620000226200005a60201b60201c565b6040518060c00160405280609481526020016200162160949139600490805190602001906200005392919062000194565b50620002a9565b6040518060400160405280600481526020017f6e756c6c0000000000000000000000000000000000000000000000000000000081525060009080519060200190620000a792919062000194565b506040518060400160405280600481526020017f696e69740000000000000000000000000000000000000000000000000000000081525060019080519060200190620000f592919062000194565b506040518060400160405280600481526020017f696e697400000000000000000000000000000000000000000000000000000000815250600290805190602001906200014392919062000194565b506040518060400160405280600481526020017f696e697400000000000000000000000000000000000000000000000000000000815250600390805190602001906200019192919062000194565b50565b828054620001a29062000244565b90600052602060002090601f016020900481019282620001c6576000855562000212565b82601f10620001e157805160ff191683800117855562000212565b8280016001018555821562000212579182015b8281111562000211578251825591602001919060010190620001f4565b5b50905062000221919062000225565b5090565b5b808211156200024057600081600090555060010162000226565b5090565b600060028204905060018216806200025d57607f821691505b602082108114156200027457620002736200027a565b5b50919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b61136880620002b96000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c8063caf94bc011610066578063caf94bc01461014b578063cd568d1f14610155578063e3737d7d14610173578063e53a618d1461018f578063e8609d37146101ab5761009e565b80630c4dd374146100a357806326a9aec5146100c157806339c47234146100df57806340989152146100fd5780637be1bb1b1461011b575b600080fd5b6100ab6101c7565b6040516100b8919061107b565b60405180910390f35b6100c9610255565b6040516100d6919061107b565b60405180910390f35b6100e76102e3565b6040516100f4919061107b565b60405180910390f35b610105610371565b604051610112919061107b565b60405180910390f35b61013560048036038101906101309190610e82565b6103ff565b604051610142919061107b565b60405180910390f35b61015361064e565b005b61015d610780565b60405161016a919061107b565b60405180910390f35b61018d60048036038101906101889190610ecb565b61080e565b005b6101a960048036038101906101a49190610e82565b6109c8565b005b6101c560048036038101906101c09190610ecb565b610bfd565b005b600480546101d4906111d1565b80601f0160208091040260200160405190810160405280929190818152602001828054610200906111d1565b801561024d5780601f106102225761010080835404028352916020019161024d565b820191906000526020600020905b81548152906001019060200180831161023057829003601f168201915b505050505081565b60038054610262906111d1565b80601f016020809104026020016040519081016040528092919081815260200182805461028e906111d1565b80156102db5780601f106102b0576101008083540402835291602001916102db565b820191906000526020600020905b8154815290600101906020018083116102be57829003601f168201915b505050505081565b600180546102f0906111d1565b80601f016020809104026020016040519081016040528092919081815260200182805461031c906111d1565b80156103695780601f1061033e57610100808354040283529160200191610369565b820191906000526020600020905b81548152906001019060200180831161034c57829003601f168201915b505050505081565b6002805461037e906111d1565b80601f01602080910402602001604051908101604052809291908181526020018280546103aa906111d1565b80156103f75780601f106103cc576101008083540402835291602001916103f7565b820191906000526020600020905b8154815290600101906020018083116103da57829003601f168201915b505050505081565b60606040518060400160405280600381526020017f737263000000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156104de5760018054610459906111d1565b80601f0160208091040260200160405190810160405280929190818152602001828054610485906111d1565b80156104d25780601f106104a7576101008083540402835291602001916104d2565b820191906000526020600020905b8154815290600101906020018083116104b557829003601f168201915b50505050509050610649565b6040518060400160405280600481526020017f646573740000000000000000000000000000000000000000000000000000000081525080519060200120828051906020012014156105bb5760028054610536906111d1565b80601f0160208091040260200160405190810160405280929190818152602001828054610562906111d1565b80156105af5780601f10610584576101008083540402835291602001916105af565b820191906000526020600020905b81548152906001019060200180831161059257829003601f168201915b50505050509050610649565b600380546105c8906111d1565b80601f01602080910402602001604051908101604052809291908181526020018280546105f4906111d1565b80156106415780601f1061061657610100808354040283529160200191610641565b820191906000526020600020905b81548152906001019060200180831161062457829003601f168201915b505050505090505b919050565b6040518060400160405280600481526020017f6e756c6c0000000000000000000000000000000000000000000000000000000081525060009080519060200190610699929190610d6f565b506040518060400160405280600481526020017f696e697400000000000000000000000000000000000000000000000000000000815250600190805190602001906106e5929190610d6f565b506040518060400160405280600481526020017f696e69740000000000000000000000000000000000000000000000000000000081525060029080519060200190610731929190610d6f565b506040518060400160405280600481526020017f696e6974000000000000000000000000000000000000000000000000000000008152506003908051906020019061077d929190610d6f565b50565b6000805461078d906111d1565b80601f01602080910402602001604051908101604052809291908181526020018280546107b9906111d1565b80156108065780601f106107db57610100808354040283529160200191610806565b820191906000526020600020905b8154815290600101906020018083116107e957829003601f168201915b505050505081565b818051906020012060006040516108259190611064565b60405180910390201461086d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016108649061109d565b60405180910390fd5b60006040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525090506040518060400160405280600381526020017f7372630000000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561090e578060019080519060200190610908929190610d6f565b5061098e565b6040518060400160405280600481526020017f6465737400000000000000000000000000000000000000000000000000000000815250805190602001208280519060200120141561097557806002908051906020019061096f929190610d6f565b5061098d565b806003908051906020019061098b929190610d6f565b505b5b7f7d2211d63bbbbeea171c05f703e2748272ed0f62af7970a1f95da2fbeec340236040516109bb906110bd565b60405180910390a1505050565b808051906020012060006040516109df9190611064565b604051809103902014610a27576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a1e9061109d565b60405180910390fd5b6040518060400160405280600781526020017f7072657061726500000000000000000000000000000000000000000000000000815250805190602001206001604051610a739190611064565b6040518091039020148015610ad957506040518060400160405280600781526020017f7072657061726500000000000000000000000000000000000000000000000000815250805190602001206002604051610acf9190611064565b6040518091039020145b8015610b1057506002604051610aef9190611064565b60405180910390206001604051610b069190611064565b6040518091039020145b15610bfa576040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525060019080519060200190610b60929190610d6f565b506040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525060029080519060200190610bac929190610d6f565b506040518060400160405280600681526020017f636f6d6d6974000000000000000000000000000000000000000000000000000081525060039080519060200190610bf8929190610d6f565b505b50565b8160009080519060200190610c13929190610d6f565b5060006040518060400160405280600781526020017f707265706172650000000000000000000000000000000000000000000000000081525090506040518060400160405280600381526020017f73726300000000000000000000000000000000000000000000000000000000008152508051906020012082805190602001201415610cb5578060019080519060200190610caf929190610d6f565b50610d35565b6040518060400160405280600481526020017f64657374000000000000000000000000000000000000000000000000000000008152508051906020012082805190602001201415610d1c578060029080519060200190610d16929190610d6f565b50610d34565b8060039080519060200190610d32929190610d6f565b505b5b7f7d2211d63bbbbeea171c05f703e2748272ed0f62af7970a1f95da2fbeec34023604051610d62906110dd565b60405180910390a1505050565b828054610d7b906111d1565b90600052602060002090601f016020900481019282610d9d5760008555610de4565b82601f10610db657805160ff1916838001178555610de4565b82800160010185558215610de4579182015b82811115610de3578251825591602001919060010190610dc8565b5b509050610df19190610df5565b5090565b5b80821115610e0e576000816000905550600101610df6565b5090565b6000610e25610e2084611122565b6110fd565b905082815260208101848484011115610e4157610e40611297565b5b610e4c84828561118f565b509392505050565b600082601f830112610e6957610e68611292565b5b8135610e79848260208601610e12565b91505092915050565b600060208284031215610e9857610e976112a1565b5b600082013567ffffffffffffffff811115610eb657610eb561129c565b5b610ec284828501610e54565b91505092915050565b60008060408385031215610ee257610ee16112a1565b5b600083013567ffffffffffffffff811115610f0057610eff61129c565b5b610f0c85828601610e54565b925050602083013567ffffffffffffffff811115610f2d57610f2c61129c565b5b610f3985828601610e54565b9150509250929050565b60008154610f50816111d1565b610f5a8186611173565b94506001821660008114610f755760018114610f8657610fb9565b60ff19831686528186019350610fb9565b610f8f85611153565b60005b83811015610fb157815481890152600182019150602081019050610f92565b838801955050505b50505092915050565b6000610fcd82611168565b610fd7818561117e565b9350610fe781856020860161119e565b610ff0816112a6565b840191505092915050565b6000611008600e8361117e565b9150611013826112b7565b602082019050919050565b600061102b60158361117e565b9150611036826112e0565b602082019050919050565b600061104e60168361117e565b915061105982611309565b602082019050919050565b60006110708284610f43565b915081905092915050565b600060208201905081810360008301526110958184610fc2565b905092915050565b600060208201905081810360008301526110b681610ffb565b9050919050565b600060208201905081810360008301526110d68161101e565b9050919050565b600060208201905081810360008301526110f681611041565b9050919050565b6000611107611118565b90506111138282611203565b919050565b6000604051905090565b600067ffffffffffffffff82111561113d5761113c611263565b5b611146826112a6565b9050602081019050919050565b60008190508160005260206000209050919050565b600081519050919050565b600081905092915050565b600082825260208201905092915050565b82818337600083830152505050565b60005b838110156111bc5780820151818401526020810190506111a1565b838111156111cb576000848401525b50505050565b600060028204905060018216806111e957607f821691505b602082108114156111fd576111fc611234565b5b50919050565b61120c826112a6565b810181811067ffffffffffffffff8211171561122b5761122a611263565b5b80604052505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f747849642069732077726f6e672e000000000000000000000000000000000000600082015250565b7f7365742073746174757320746f20636f6d6d69742e0000000000000000000000600082015250565b7f7365742073746174757320746f20707265706172652e0000000000000000000060008201525056fea264697066735822122059ae252cd3b00009040cf2592a2d536c537ef4eeb00b925dab0d37648bae34ac64736f6c634300080700332264617461436f6d6d6f6e223a7b22736f75726365223a7b226e6f64654964223a22222c22636861696e4964223a22227d2c2264657374696e6174696f6e223a7b226e6f64654964223a22222c22636861696e4964223a22227d2c22747854797065223a22222c227478436f6e74656e74223a22222c2274696d655374616d70223a22222c227369676e6174757265223a22227d";

    public static final String FUNC_CHECKTXSTATUS = "checkTxStatus";

    public static final String FUNC_DATACOMMONFORMAT = "dataCommonFormat";

    public static final String FUNC_DESTSTATUS = "destStatus";

    public static final String FUNC_GETCURRENTSTATUS = "getCurrentStatus";

    public static final String FUNC_INITTXSTATUS = "initTxStatus";

    public static final String FUNC_RELAYSTATUS = "relayStatus";

    public static final String FUNC_SETSTATUSTOCOMMIT = "setStatusToCommit";

    public static final String FUNC_SETSTATUSTOPREPARE = "setStatusToPrepare";

    public static final String FUNC_SRCSTATUS = "srcStatus";

    public static final String FUNC_TXID = "txId";

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
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHECKSTATUS_EVENT, transactionReceipt);
        ArrayList<CheckStatusEventResponse> responses = new ArrayList<CheckStatusEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
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
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHECKSTATUS_EVENT, log);
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
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETSTATUS_EVENT, transactionReceipt);
        ArrayList<SetStatusEventResponse> responses = new ArrayList<SetStatusEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
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
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SETSTATUS_EVENT, log);
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

    public RemoteFunctionCall<TransactionReceipt> checkTxStatus(String _txId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHECKTXSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_txId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> dataCommonFormat() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DATACOMMONFORMAT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> destStatus() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DESTSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getCurrentStatus(String _chainName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCURRENTSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_chainName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initTxStatus() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITTXSTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> relayStatus() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RELAYSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setStatusToCommit(String _txId, String _chainName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTATUSTOCOMMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_txId), 
                new org.web3j.abi.datatypes.Utf8String(_chainName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setStatusToPrepare(String _txId, String _chainName) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSTATUSTOPREPARE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_txId), 
                new org.web3j.abi.datatypes.Utf8String(_chainName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> srcStatus() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SRCSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> txId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TXID, 
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
