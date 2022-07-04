// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.4.22 <0.9.0;

contract Status {

    string public txId;
    string public srcStatus;
    string public destStatus;
    string public relayStatus;
    string public dataCommonFormat;

    event setStatus(string status);
    event checkStatus(string status);

    constructor () {
        initTxStatus();
        dataCommonFormat = "\"dataCommon\":{\"source\":{\"nodeId\":\"\",\"chainId\":\"\"},\"destination\":{\"nodeId\":\"\",\"chainId\":\"\"},\"txType\":\"\",\"txContent\":\"\",\"timeStamp\":\"\",\"signature\":\"\"}";
    }

    function initTxStatus() public {
        txId = "null";
        srcStatus = "init";
        destStatus = "init";
        relayStatus = "init";
    }

    function setStatusToPrepare(string memory _txId, string memory _chainName) public {

        txId = _txId;

        string memory status = "prepare";
        if (keccak256(bytes(_chainName)) == keccak256(bytes("src"))) {
            srcStatus = status;
        } else if (keccak256(bytes(_chainName)) == keccak256(bytes("dest"))) {
            destStatus = status;
        } else {
            relayStatus = status;
        }

        emit setStatus("set status to prepare.");
    }

    function setStatusToCommit(string memory _txId, string memory _chainName) public {

        require(keccak256(bytes(txId)) == keccak256(bytes(_txId)), "txId is wrong.");

        string memory status = "commit";
        if (keccak256(bytes(_chainName)) == keccak256(bytes("src"))) {
            srcStatus = status;
        } else if (keccak256(bytes(_chainName)) == keccak256(bytes("dest"))) {
            destStatus = status;
        } else {
            relayStatus = status;
        }

        emit setStatus("set status to commit.");
    }

    function getCurrentStatus(string memory _chainName) public view returns (string memory) {

        if (keccak256(bytes(_chainName)) == keccak256(bytes("src"))) {
            return srcStatus;
        } else if (keccak256(bytes(_chainName)) == keccak256(bytes("dest"))) {
            return destStatus;
        } else {
            return relayStatus;
        }
    }

    function checkTxStatus(string memory _txId) public {

        require(keccak256(bytes(txId)) == keccak256(bytes(_txId)), "txId is wrong.");

        if (keccak256(bytes(srcStatus)) == keccak256(bytes("prepare"))
        && keccak256(bytes(destStatus)) == keccak256(bytes("prepare"))
            && keccak256(bytes(srcStatus)) == keccak256(bytes(destStatus))) {
            srcStatus = "commit";
            destStatus = "commit";
            relayStatus = "commit";
        }
    }

}