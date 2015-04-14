package com.tiarebalbi.test.domain;

/**
 * @author Tiarê Balbi Bonamini
 */
public class CellPhone {

    private Boolean state;

    private String model;

    public CellPhone(String model) {
        this.model = model;
        this.state = false;
    }

    public Boolean isOn() {
        return state;
    }

    public String getModel() {
        return model;
    }

    public void turnOn() {
        this.state = true;
    }

    public void turnOff() {
        this.state = false;
    }
}
