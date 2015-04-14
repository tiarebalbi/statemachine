package com.tiarebalbi.test.event;

import com.tiarebalbi.test.domain.CellPhone;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.logging.Logger;

/**
 * @author Tiarê Balbi Bonamini
 */
@WithStateMachine
public class PhoneEvent {

    private final static Logger LOGGER = Logger.getLogger("c.t.t.e.PhoneEvent");

    @OnTransition(target = "TURN_ON")
    public void turnOn(CellPhone cellPhone) {
        LOGGER.info("Turning on cellphone");
        cellPhone.turnOn();
    }

    @OnTransition(target = "TURN_OFF")
    public void turnOff(CellPhone cellPhone) {
        LOGGER.info("Turning off cellphone");
        cellPhone.turnOff();
    }
}
