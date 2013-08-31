package org.jcrete.lambdas.examples.strategy;

/**
 * See http://javacamp.org/designPattern/strategy.html
 */
public class Null implements FortuneCookies {
    @Override
    public void print() {
        System.out.println("You got nothing");
    }
}
