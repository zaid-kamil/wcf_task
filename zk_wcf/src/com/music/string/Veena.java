package com.music.string;

import com.music.Playable;

public class Veena implements Playable {
    @Override
    public void play() {
        System.out.println("Veena is being played");
    }
}