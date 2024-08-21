package org.receipt.generator.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cor")
@Component
@Data
public class RulesConfig {

    private Map<String, List<String>> chain;
}
