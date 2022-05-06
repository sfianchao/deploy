package idsl.crosschain.deploy.controller;

import idsl.crosschain.deploy.service.LoadService;
import idsl.crosschain.deploy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/load")
public class LoadController {

    @Autowired
    public final TestService testService;

    @Autowired
    public final LoadService loadService;

    public LoadController(TestService testService,
                          LoadService loadService) {
        this.testService = testService;
        this.loadService = loadService;
    }

    @GetMapping(value = "/data")
    public ResponseEntity<?> loadData(@RequestBody String message) {
        return new ResponseEntity<>(loadService.loadData(), HttpStatus.OK);
    }

}
