package org.receipt.generator.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RulesUtil {

    private final RulesConfig chain;

    public List<String> getRulesOperations(String productType) {

        return chain.getChain().get(productType.toLowerCase());
    }

}
