package idsl.crosschain.deploy.controller;

import idsl.crosschain.deploy.service.DeployService;
import idsl.crosschain.deploy.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deploy")
public class DeployController {

    public final TestService testService;
    public final DeployService deployService;

    public DeployController(TestService testService,
                            DeployService deployService) {
        this.testService = testService;
        this.deployService = deployService;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>(testService.testConnection(), HttpStatus.OK);
    }

    @PostMapping(value = "/contract/{chainName}")
    public ResponseEntity<?> deployContract(@PathVariable String chainName) {
        return new ResponseEntity<>(deployService.deployContract(chainName), HttpStatus.CREATED);
    }

}
