#!/bin/bash
set -e

# setup smart contract
echo "\nStep 1. compile solidity file\n"
sudo solc Status.sol --bin --abi --optimize --overwrite -o ./

echo "\nStep 2. web3j convert to java class\n"
web3j generate solidity -b ./Status.bin -a ./Status.abi -o ./src/main/java -p idsl.crosschain.transfer.contract

