package org.jcrete.lambdas.examples.strategy;

/**
 * See http://javacamp.org/designPattern/strategy.html
 */
public class Five implements FortuneCookies {

    @Override
    public void print() {
        System.out.println("It is your turn to get it");
    }
}
