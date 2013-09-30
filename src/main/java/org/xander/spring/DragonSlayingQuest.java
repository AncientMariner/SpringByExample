package org.xander.spring;

public class DragonSlayingQuest implements Quest{
    @Override
    public void embark() {
        System.out.println("This is dragon slaying quest");
    }
}
