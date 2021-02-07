package com.example.aop.aspectjAdvice;

import org.springframework.stereotype.Component;

@Component("johnMayer")
public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Gravity is working...");
    }

    @Override
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    @Override
    public void rest() {
        System.out.println("rest");
    }

    @Override
    public void talk() {
        System.out.println("talk");
    }
}
