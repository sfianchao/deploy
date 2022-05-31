package idsl.crosschain.deploy.util;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Data
@Component
public abstract class ContractUtil {

    @Value("${contract.address.source}")
    public String SOURCE_CONTRACT_ADDRESS;

    @Value("${contract.address.relay}")
    public String RELAY_CONTRACT_ADDRESS;

    @Value("${contract.address.destination}")
    public String DESTINATION_CONTRACT_ADDRESS;

    @Autowired
    public ApplicationContext applicationContext;

    public abstract JSONObject deploy(String chainBuilder);

    public abstract JSONObject load(String chainBuilder);

}
