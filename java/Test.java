import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

/**
 * Created by j.chittoda on 18-Aug-17.
 */
public class Test {
    public static void main(String[] args) {

        Test test = new Test();

         test.GetClientVersion();
        //test.deployContract();
        //test.can_I_Receive();
        //test.getContractBalance();
        //test.sendMeOneEth();
        test.killContract();
    }

    private Web3j web3;
    private Credentials credentials;
    private String CONTRACT_ADDRESS = "0x8aec305dbb2cb96be809e691a23e2b4e23a84308";

    public Test(){
        try {
            web3 = Web3j.build(new HttpService("https://ropsten.infura.io/gc91pM9K2fuyiEMla2uk"));
            //Public : 7c3f8354762d25dea8cd100fed1227abb9dace6a
            credentials = WalletUtils.loadCredentials("jitendra", "/Users/jitendra/Desktop/web3j/UTC--2017-08-18T19-50-42.116000000Z--7c3f8354762d25dea8cd100fed1227abb9dace6a.json");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void GetClientVersion(){
        try {

            Web3ClientVersion version = web3.web3ClientVersion().sendAsync().get();
            System.out.println("version : " + version.getWeb3ClientVersion());


        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void deployContract(){
        System.out.println("Going to deploy smart contract");
        try {

            AskForEth contract = AskForEth.deploy(
                    web3, credentials,
                    new BigInteger("22000000000"), new BigInteger("510000"),
                    new BigInteger("0")
                    ).get();
            System.out.printf("Contract Address : " + contract.getContractAddress());
        } catch(Exception e){
            e.printStackTrace();
        }

    }


    public void can_I_Receive(){
        System.out.println("Call the method can_I_Receive()");
        try{
            AskForEth contract = AskForEth.load(
                    CONTRACT_ADDRESS, web3, credentials, new BigInteger("22000000000"), new BigInteger("210000"));

            Bool b  = contract.can_I_Receive().get();
            System.out.println("Can I Receive Ether : " + b.getValue());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void getContractBalance(){
        System.out.println("Call the method getContractBalance()");
        try{
            AskForEth contract = AskForEth.load(
                    CONTRACT_ADDRESS, web3, credentials, new BigInteger("22000000000"), new BigInteger("210000"));

            Uint256 bal  = contract.getContractBalance().get();
            System.out.println( "Contract Balance : " + bal.getValue());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMeOneEth(){
        System.out.println("Call the method sendMeOneEth()");
        try{
            AskForEth contract = AskForEth.load(
                    CONTRACT_ADDRESS, web3, credentials, new BigInteger("22000000000"), new BigInteger("210000"));

            TransactionReceipt receipt = contract.sendMeOneEth().get();
            System.out.println( "SendMeOneEth TxHash : " + receipt.getTransactionHash());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void killContract(){
        System.out.println("Call the method kill()");
        try{
            AskForEth contract = AskForEth.load(
                    CONTRACT_ADDRESS, web3, credentials, new BigInteger("22000000000"), new BigInteger("210000"));

            TransactionReceipt receipt = contract.kill().get();
            System.out.println( "Kill TxHash : " + receipt.getTransactionHash());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}