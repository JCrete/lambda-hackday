package org.jcrete.lambdas.examples.strategy;

/**
 * See http://javacamp.org/designPattern/strategy.html
 */
public class Two implements FortuneCookies {
    @Override
    public void print() {
        System.out.println("It is never too late to start");
    }
}
