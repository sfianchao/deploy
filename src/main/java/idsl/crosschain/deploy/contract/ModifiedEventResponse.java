package idsl.crosschain.deploy.contract;

import org.web3j.protocol.core.methods.response.BaseEventResponse;

public class ModifiedEventResponse extends BaseEventResponse {

    public byte[] oldGreetingIdx;

    public byte[] newGreetingIdx;

    public String oldGreeting;

    public String newGreeting;
}
