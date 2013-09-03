package org.xander.springByExample.Part_1;

public class Constructor_Injection_Message {
    private String message = null;

    public Constructor_Injection_Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
