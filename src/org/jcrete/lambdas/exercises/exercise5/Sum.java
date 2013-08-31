/*
 * #%L
 * lambda-tutorial
 * %%
 * Copyright (C) 2013 Adopt OpenJDK
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
package org.jcrete.lambdas.exercises.exercise5;

/**
 * Factor out the common pattern. Create one general sum() method that returns the sum of any function (of integers, factorials, cubes etc.)
 */
public class Sum {

    /**
     * TODO: This method should be replaced by a functional sum() method
     *
     * @param a from
     * @param b to inclusive
     * @return the sum of integers between a and b
     */
    public static int sumOfIntegers(int a, int b) {
        if (a > b) return 0;
        else return a + sumOfIntegers(a + 1, b);
    }

    /**
     * @param x
     * @return x^3
     */
    public static int cube(int x) {
        return x * x * x;
    }

    /**
     * TODO: This method should be replaced by a functional sum() method
     *
     * @param a from
     * @param b to inclusive
     * @return the sum of cubes between a and b
     */
    public static int sumOfCubes(int a, int b) {
        if (a > b) return 0;
        else return cube(a) + sumOfCubes(a + 1, b);
    }


    /**
     * @param x
     * @return x!
     */
    public static int factorial(int x) {
        return (x == 0) ? 1 : x * factorial(x - 1);
    }

    /**
     * TODO: This method should be replaced by a functional sum() method
     *
     * @param a from
     * @param b to inclusive
     * @return the sum of factorials between a and b
     */
    public static int sumOfFactorials(int a, int b) {
        if (a > b) return 0;
        else return factorial(a) + sumOfFactorials(a + 1, b);
    }

    public static void main(String[] args) {
        System.out.println("1+2+...+10=" + sumOfIntegers(1, 10));
        System.out.println("1^3+2^3+...+5^3=" + sumOfCubes(1, 5));
        System.out.println("1!+2!+...+10!=" + sumOfFactorials(1, 10));
    }
}
