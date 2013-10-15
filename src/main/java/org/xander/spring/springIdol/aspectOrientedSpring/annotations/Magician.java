package org.xander.spring.springIdol.aspectOrientedSpring.annotations;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //disable to allow Audience aspect working
public class Magician implements MindReader{
    private String thoughts;

    @Pointcut("execution(* org.xander.spring.springIdol.aspectOrientedSpring.annotations.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void thinking(String thoughts) {
    }

    @Override
    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts){
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
