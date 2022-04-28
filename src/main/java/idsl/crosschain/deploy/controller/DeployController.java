package idsl.crosschain.deploy.controller;

import idsl.crosschain.deploy.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/deploy")
public class DeployController {

    public final TestService testService;

    public DeployController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(testService.testConnection(), HttpStatus.OK);
    }

    @GetMapping(value = "/contract")
    public ResponseEntity<?> deployContract() {
        return new ResponseEntity<>(testService.loadData(), HttpStatus.OK);
    }

}
