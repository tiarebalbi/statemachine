package com.tiarebalbi.test.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * @author Tiarê Balbi Bonamini
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyPromptProvider extends DefaultPromptProvider {

    @Override
    public String getPrompt() {
        return "statemachine>";
    }


    @Override
    public String getProviderName() {
        return "Statemachine";
    }

}