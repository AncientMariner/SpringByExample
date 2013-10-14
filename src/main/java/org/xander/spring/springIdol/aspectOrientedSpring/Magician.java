package org.xander.spring.springIdol.aspectOrientedSpring;

public class Magician implements MindReader {
    private String thoughts;

    public Magician(String thoughts) {
        this.thoughts = thoughts;
    }

    @Override
    public void interceptThoughts(){
        System.out.println("He was thinking of " + getThoughts());
        this.thoughts = "Ruby's King";
        System.out.println("Intercepting volunteer's thoughts");
        System.out.println("Now he is thinking of " + getThoughts());
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
