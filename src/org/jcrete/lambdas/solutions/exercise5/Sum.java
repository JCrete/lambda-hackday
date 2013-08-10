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
package org.jcrete.lambdas.solutions.exercise5;

import java.util.function.Function;

/**
 * Factor out the common pattern. Create one general method sum() that returns the sum of any function (of integers, factorials, cubes etc.)
 */
public class Sum {

    /**
     * @param function to apply, e.g. factorial
     * @param a from
     * @param b to
     * @return the sum of the result of the function from a to b
     */
    public static int sum(Function<Integer, Integer> function, int a, int b) {
        if (a > b) return 0;
        else return function.apply(a) + sum(function, a + 1, b);
    }

    /**
     * @param x
     * @return x^3
     */
    public static int cube(int x) {
        return x * x * x;
    }

    /**
     * @param x
     * @return x!
     */
    public static int factorial(int x) {
        return (x == 0) ? 1 : x * factorial(x - 1);
    }

    public static void main(String[] args) {
         System.out.println("1+2+...+10=" + sum(x -> x , 1, 10));
         System.out.println("1^3+2^3+...+5^3=" + sum(x -> cube(x), 1, 5));
         System.out.println("1!+2!+...+10!=" + sum(x -> factorial(x), 1, 10));
     }
}
