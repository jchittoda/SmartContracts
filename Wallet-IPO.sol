pragma solidity ^0.4.11;

/*
 Wallet for IPO style.
 Once the crowdfunding done, it should return the extra ETH
 back to the investor.
 
 (c) Jitendra Chittoda 2017. The MIT Licence.
*/

contract Wallet{
    address owner;
    mapping(address=>uint) balanceOf;
    
    uint totalSupply;
    uint totalETHReceived;
    
    function Wallet(){
        owner = msg.sender;
    }
    
    /* Distribute the coins */
    function distributeCoin() isOwner {
        
    }
    
    /* Returns the extra ETH that received */ 
    function returnExtraETH() isOwner {
        
    }
    
    modifier isOwner() {
        require(msg.sender == owner);
        _;
    }
    
    /* Receive ETH amount */
    function () payable{
        
    }
    
}
