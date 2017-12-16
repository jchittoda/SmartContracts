pragma solidity ^0.4.19;

/*
 * This Smart Contract has been created for demo purpose.
 * This Smart Contract can send 0.1 free ETH to a wallet. Once 0.1 ETH is given
 * to a wallet, same wallet cannot receive more ETHs from this Smart Contract
 *
 * Jitendra Chittoda (c) 2017, The MIT Licence.
 */
contract AskForEth {
    
    /* This SmartContract's Owner's wallet address */
    address owner;
    
    /* Map of Address=>amount */
    /* Once 0.1 ETH is given to a wallet, should not send again */
    mapping (address=>uint) hasGiven;
    
    /* Event for loggin InSuffecientBalance */
    event InSuffecientBalance(uint balance);

    /* ETH Already Sent to address */
    event AlreadySent();
    
    uint ONE_ETH = 0.1 ether;
    
    /*
     * Constructor of Contract.
     * Initialize the owner
     */
    function AskForEth(){
        owner = msg.sender;
    }
    
    /*
     * Whosoever calls this method, Contract send him 0.1 ETH,
     * If the contract has suffecient balance.
     */
    function sendMeSomeEth(){
        if(this.balance >= ONE_ETH){
            if(hasGiven[msg.sender] == 0){
                msg.sender.transfer(ONE_ETH);
                hasGiven[msg.sender] = ONE_ETH;
            } else {
                AlreadySent();
            }
        } else {
            InSuffecientBalance(this.balance);
        }
    }
    
    /*
     * Can a wallet receive the 0.1 ETH from this Contract?
     * If a asking wallet has not taken 0.1 ETH then contract returns true
     * If a asking wallet has already taken 0.1 ETH from this contract then return false
     * Before sending 0.1 ETH also check that the Contract has suffecient balance.
     */
    function can_I_ReceiveEth() constant returns (bool){
        if(hasGiven[msg.sender] == 0 && this.balance >= ONE_ETH){
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * Returns the balance of the ETH this Smart Contract has
     */
    function getContractBalance() constant returns(uint){
        return this.balance;
    }
    
    /* 
     * When killed by Owner,
     * Send all the Ethers this contract holds back to owner
     */
    function kill() isOwner{
        suicide(owner);
    }
    
    /* Allow this SmartContract to Receive Ethers */
    function() payable{
    }
    
    /* Modifier isOwner */
    modifier isOwner() {
        require(msg.sender == owner);
        _;
    }
}
