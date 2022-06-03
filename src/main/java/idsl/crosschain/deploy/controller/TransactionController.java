package idsl.crosschain.deploy.controller;

import idsl.crosschain.deploy.dto.request.LaunchTxRequest;
import idsl.crosschain.deploy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "/launch")
    public ResponseEntity<?> launchTransaction(@RequestBody LaunchTxRequest launchTxRequest) {
        return new ResponseEntity<>(transactionService.launchTx(launchTxRequest), HttpStatus.CREATED);
    }
}
