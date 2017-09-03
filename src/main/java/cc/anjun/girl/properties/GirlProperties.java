package cc.anjun.girl.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@ConfigurationProperties(prefix = "girl")
@Data
@Component
public class GirlProperties {
    private String cupSize;
    private Integer age;
}
