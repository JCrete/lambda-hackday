package org.jcrete.lambdas.examples.strategy;

/**
 * See http://javacamp.org/designPattern/strategy.html
 */
public class Dice {
    public int throwIt() {
        return (int) (Math.random() * 6) + 1;
    }
}
