package idsl.crosschain.deploy.controller;

import idsl.crosschain.deploy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/deploy")
public class DeployController {

    @Autowired
    public TestService testService;

    public DeployController () {
    }

    @GetMapping(value = "")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(testService.testConnection(), HttpStatus.OK);
    }

}
