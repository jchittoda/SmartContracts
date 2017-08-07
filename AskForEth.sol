pragma solidity ^0.4.11;

contract AskForEth {
    address owner;
    
    function AskForEth(){
        owner = msg.sender;
    }
    
    /*
     * Whosoever calls this method send him 1 ETH,
     * If the contract has suffecient balance.
     */
    function pleaseSendOne(){
        require(this.balance < 1000000000000000000);
            
        //1 ETH
        msg.sender.transfer(1000000000000000000);
    }
    
    /* 
     * When killed by Owner,
     * Send all the money this contract holds back to owner
     */
    function kill() isOwner{
        suicide(owner);
    }
    
    /* To Receive ETH */
    function() payable{
    }
    
    /* Modifier isOwner */
    modifier isOwner() {
        require(msg.sender == owner);
        _;
    }
}