package org.jcrete.lambdas.examples.strategy;

/**
 * @see {@link http://javacamp.org/designPattern/strategy.html}
 */
public class Main {
    static void goodFortune() {
        int luckyNum = new Dice().throwIt();
        System.out.println(luckyNum);
        FortuneCookies fc;
        switch (luckyNum) {
            case 2:
                fc = new Two();
                break;
            case 5:
                fc = new Five();
                break;
            //more
            default:
                fc = new Null();
        }
        fc.print();
    }

    static void goodFortuneWithLambdas() {
        int luckyNum = new Dice().throwIt();
        System.out.println(luckyNum);
        FortuneCookies fc;
        switch (luckyNum) {
            case 2:
                fc = () -> System.out.println("It is never too late to start");
                break;
            case 5:
                fc = () -> System.out.println("It is your turn to get it");
                break;
            //more
            default:
                fc = () -> System.out.println("You got nothing");
        }
        fc.print();
    }

    public static void main(String[] args) {
        goodFortune();
        goodFortuneWithLambdas();
    }
}
