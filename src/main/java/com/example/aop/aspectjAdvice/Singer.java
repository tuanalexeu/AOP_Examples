package com.example.aop.aspectjAdvice;

import javax.sound.midi.Instrument;

public interface Singer {
    void sing();
    void sing(Guitar guitar);
    void rest();
    void talk();
}
