package idsl.crosschain.deploy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.ApplicationContext;

@Slf4j
//@SpringBootApplication
@SpringBootApplication(exclude = {KafkaAutoConfiguration.class, DataSourceAutoConfiguration.class})
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
