package idsl.crosschain.deploy;

import idsl.crosschain.deploy.config.QuorumConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Slf4j
//@SpringBootApplication
@SpringBootApplication(exclude = {KafkaAutoConfiguration.class, DataSourceAutoConfiguration.class})
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(
//        type = FilterType.ASSIGNABLE_TYPE, classes = {QuorumConfig.class})})
public class DeployApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
