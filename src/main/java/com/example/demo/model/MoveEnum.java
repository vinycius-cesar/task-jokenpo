// Move.java
package com.example.demo.model;

import java.util.Random;

public enum MoveEnum {
    PEDRA, PAPEL, TESOURA;

    private static final MoveEnum[] VALUES = values();
    private static final Random RANDOM = new Random();

    public static MoveEnum getRandom() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}
