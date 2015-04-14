package com.tiarebalbi.test.commands;

import com.tiarebalbi.test.domain.CellPhone;
import com.tiarebalbi.test.domain.Events;
import com.tiarebalbi.test.domain.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * @author Tiarê Balbi Bonamini
 */
@Component
class PhoneCommand implements CommandMarker {

    @Autowired
    private CellPhone cellPhone;

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @CliAvailabilityIndicator({"phone simple"})
    public boolean isCommandAvailable() {
        return true;
    }

    @CliCommand(value = "phone state", help = "Print the Phone State")
    public String status() {
        return (cellPhone.isOn() ? "Phone ON!" : "Phone OFF :(");
    }

    @CliCommand(value = "phone on", help = "Turn on the cellphone")
    public String turnOn() {
        stateMachine.sendEvent(Events.TURN_ON);
        return "Turning ON...";
    }

    @CliCommand(value = "phone off", help = "Turn off the cellphone")
    public String turnOff() {
        stateMachine.sendEvent(Events.TURN_ON);
        return "Turning OFF...";
    }
}