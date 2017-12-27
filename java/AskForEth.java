
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.0.
 */
public final class AskForEth extends Contract {
    private static final String BINARY = "6060604052670de0b6b3a7640000600255341561001b57600080fd5b5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b6103968061006d6000396000f30060606040523615610060576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631ed9af6e146100645780632e2dcf281461009157806341c0e1b5146100a65780636f9fb98a146100bb575b5b5b005b341561006f57600080fd5b6100776100e4565b604051808215151515815260200191505060405180910390f35b341561009c57600080fd5b6100a4610168565b005b34156100b157600080fd5b6100b96102b2565b005b34156100c657600080fd5b6100ce61034a565b6040518082815260200191505060405180910390f35b600080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205414801561014d57506002543073ffffffffffffffffffffffffffffffffffffffff163110155b1561015b5760019050610165565b60009050610165565b5b90565b6002543073ffffffffffffffffffffffffffffffffffffffff1631101515610260576000600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054141561025b573373ffffffffffffffffffffffffffffffffffffffff166108fc6002549081150290604051600060405180830381858888f19350505050151561021457600080fd5b600254600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b6102af565b7f9da6b71807a23485b7df5b59806a84351e86cd8009791f8d31453dcd651b7df43073ffffffffffffffffffffffffffffffffffffffff16316040518082815260200191505060405180910390a15b5b565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561030d57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b5b565b60003073ffffffffffffffffffffffffffffffffffffffff163190505b905600a165627a7a72305820df8c6f7d5135160614cf8bd74d66ffa402981347b1beff7d30f559b46f39f4770029";

    private AskForEth(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private AskForEth(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<InSuffecientBalanceEventResponse> getInSuffecientBalanceEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("InSuffecientBalance", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<InSuffecientBalanceEventResponse> responses = new ArrayList<InSuffecientBalanceEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            InSuffecientBalanceEventResponse typedResponse = new InSuffecientBalanceEventResponse();
            typedResponse.balance = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<InSuffecientBalanceEventResponse> inSuffecientBalanceEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("InSuffecientBalance", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, InSuffecientBalanceEventResponse>() {
            @Override
            public InSuffecientBalanceEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                InSuffecientBalanceEventResponse typedResponse = new InSuffecientBalanceEventResponse();
                typedResponse.balance = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<Bool> can_I_Receive() {
        Function function = new Function("can_I_Receive", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> sendMeOneEth() {
        Function function = new Function("sendMeOneEth", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getContractBalance() {
        Function function = new Function("getContractBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<AskForEth> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(AskForEth.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<AskForEth> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(AskForEth.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static AskForEth load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AskForEth(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static AskForEth load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AskForEth(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class InSuffecientBalanceEventResponse {
        public Uint256 balance;
    }
}
