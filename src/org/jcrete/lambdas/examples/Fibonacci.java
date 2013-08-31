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
package org.jcrete.lambdas.examples;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Recursive calculation of Fibonacci and Factorial using λ.
 * The only thing you cannot do with an anonymous function is recursion, exactly because you have no name to use for the recursive call.
 * Provided that the recursive call uses a name defined in the enclosing environment of the lambda (as a static instance variable) this is feasible.
 * This means that recursive definitions can only be made in the context of variable assignment and,
 * in fact—given the assignment-before-use rule for local variables—only of instance or static variable assignment.
 */
public class Fibonacci {
    private static UnaryOperator<Integer> factorial;
    private static UnaryOperator<Integer> fib;

    public static void main(String[] args) {
        fib = n -> {
            return n == 0 || n == 1 || n == 2 ? 1 : fib.apply(n - 1) + fib.apply(n - 2);
        };
        System.out.println(fib.apply(10));          // 55
        factorial = i -> {
            return i == 0 ? 1 : i * factorial.apply(i - 1);
        };
        System.out.println(factorial.apply(10));    // 3628800
    }
}
