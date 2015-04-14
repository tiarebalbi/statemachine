package com.tiarebalbi.test.config;

import com.tiarebalbi.test.domain.CellPhone;
import com.tiarebalbi.test.domain.Events;
import com.tiarebalbi.test.domain.States;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author Tiarê Balbi Bonamini
 */
@Configuration
@EnableStateMachine
public class CellPhoneState extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.OFF)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {

        transitions.withExternal()
                .source(States.OFF).target(States.ON)
                .event(Events.TURN_ON)
                .and()
                .withExternal()
                .source(States.ON).target(States.OFF)
                .event(Events.TURN_OFF);
    }

    @Bean
    public CellPhone cellPhoneDefine() {
        return new CellPhone("iPhone");
    }

}