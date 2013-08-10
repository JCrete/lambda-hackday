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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Common collection tasks:
 * <ul>
 * <li>Filter (Predicate) </li>
 * <li>Map (Mapper) </li>
 * <li>Reduce (Block) </li>
 * </ul>
 */
public class CollectionsExamples {
    private static final List<Integer> list = Arrays.asList(10, 5, 20, 30, 7, 40);

    /**
     * Filter list (imperative)
     *
     * @param list
     * @return even numbers only
     */
    private static List<Integer> getEven(List<Integer> list) {
        final List<Integer> even = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                even.add(i);
            }
        }
        return Collections.unmodifiableList(even);
    }

    /**
     * Filter list using predicates (functional)
     *
     * @param list
     * @return even numbers only
     */
    private static List<Integer> getEvenL(List<Integer> list) {
        Predicate<Integer> even = i -> i % 2 == 0;
        return list.stream().filter(even).collect(Collectors.toList());  // list.filter(i -> i % 2 == 0);
    }

    /**
     * Filter list (imperative)
     *
     * @param list a list
     * @param n a number
     * @return numbers greater than {@code n} only
     */
    private static List<Integer> getGreaterThan(List<Integer> list, int n) {
        final List<Integer> greaterThanN = new ArrayList<>();
        for (Integer i : list) {
            if (i > n) {
                greaterThanN.add(i);
            }
        }
        return Collections.unmodifiableList(greaterThanN);
    }

    /**
     * Filter list with closures (functional)
     *
     * @param list a list
     * @param n a number (closure)
     * @return numbers greater than {@code n} only
     */
    private static List<Integer> getGreaterThanL(List<Integer> list, int n) {
        return list.stream().filter(i -> i > n).collect(Collectors.toList());
    }

    /**
     * Map list (imperative)
     *
     * @param list
     * @return numbers multiplied by 2
     */
    private static List<Integer> doubleList(List<Integer> list) {
        final List<Integer> doubles = new ArrayList<>();
        for (Integer i : list) {
            doubles.add(i * 2);
        }
        return Collections.unmodifiableList(doubles);
    }

    /**
     * Map list using functions (functional)
     *
     * @param list
     * @return numbers multiplied by 2
     */
    private static List<Integer> doubleListL(List<Integer> list) {
        Function<Integer, Integer> dbl = i -> i * 2;
        return list.stream().map(dbl).collect(Collectors.toList());  // list.map(i -> i * 2);
//        list.forEach(i -> i * 2).collect(Collectors.toList());
//        return Collections.unmodifiableList(list);
    }

    /**
     * Reduce list (imperative)
     *
     * @param list
     * @return sum of numbers
     */
    private static int sum(List<Integer> list) {
        int s = 0;
        for (Integer i : list) {
            s += i;
        }
        return s;
    }

    /**
     * Reduce list using predicates (functional)
     *
     * @param list
     * @return sum of numbers
     */
    private static int sumL(List<Integer> list) {
        return list.stream().mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        System.out.println("Even (imperative)");
        print(getEven(list));
        System.out.println("Even (functional)");
        print(getEvenL(list));
        System.out.println("Greater than (imperative)");
        print(getGreaterThan(list, 20));
        System.out.println("Greater than (functional)");
        print(getGreaterThanL(list, 20));
        System.out.println("Double (imperative)");
        print(doubleList(list));
        System.out.println("Double (functional)");
        print(doubleListL(list));
        System.out.println("Sum (imperative)");
        System.out.println(sum(list));
        System.out.println("Sum (functional)");
        System.out.println(sumL(list));
    }

    private static void print(List<Integer> l) {
//        for (Integer i : l) System.out.println(i);
        l.forEach(System.out::println);
        // l.forEach(i -> System.out.println(i));
    }
}
