package idsl.crosschain.deploy.controller;

import idsl.crosschain.deploy.service.DeployService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deploy")
public class DeployController {
    public final DeployService deployService;

    public DeployController(DeployService deployService) {
        this.deployService = deployService;
    }

    @PostMapping(value = "/contract/{chainName}")
    public ResponseEntity<?> deployContract(@PathVariable String chainName) {
        return new ResponseEntity<>(deployService.deployContract(chainName), HttpStatus.CREATED);
    }

}
