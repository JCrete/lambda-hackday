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

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @see {@link "http://www.functionaljava.org" }
 */
public class FunctionalJavaExamples {
    private static final List<Integer> ints = Arrays.asList(97, 44, 67, 3, 22, 90, 1, 77, 98, 1078, 6, 64, 6, 79, 42);
    private static final List<String> strings = Arrays.asList("Hello", "There", "what", "DAY", "iS", "iT");

    /**
     * @return a list of lowercase only strings.
     */
    private static List<String> lowerCaseOnly(List<String> list) {
        return list.stream().filter(s -> s.matches("\\p{javaLowerCase}*")).collect(Collectors.toList());
    }

    /**
     * Removes elements from an array that do not meet a certain criteria.
     *
     * @param list
     */
    private static List<Integer> removeAll(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    /**
     * Removes elements from an array that do not meet a certain criteria.
     *
     * @param list
     */
    private static int foldLeft(List<Integer> list) {
        return list.stream().reduce(0, (x, y) -> x + y);
    }


    /**
     * Maps a function across the array of integers. Adds 42 to each element of the array to produce a new array.
     *
     * @param list
     */
    private static List<Integer> map42(List<Integer> list) {
        return list.stream().map(i -> i + 42).collect(Collectors.toList());
    }


    /**
     * Sorts the given list by producing a new list using a merge-sort algorithm.
     *
     * @param list
     */
    private static List<Integer> sort(List<Integer> list) {
        list.sort(Comparator.<Integer>naturalOrder());
        return list;
    }

    /**
     * Binds a function across the optional value type.
     * The function checks if the contained value is even and if it is multiples that value by 3 and returns that new value.
     * If the contained value is odd (or if there is no value), then no value is returned (none).
     *
     * @param list
     */
    private static void option(List<Optional<Integer>> list) {
        for (Optional<Integer> o : list) {
            o.filter(i -> i % 2 == 0).map(i -> i * 3).ifPresent(System.out::print);
        }
    }

    public static void main(String[] args) {
        System.out.println(lowerCaseOnly(strings));
        System.out.println(removeAll(ints));
        System.out.println(foldLeft(ints));
        System.out.println(map42(ints));
        System.out.println(sort(ints));
        List<Optional<Integer>> optionals = Arrays.asList(Optional.<Integer>of(7), Optional.<Integer>of(8), Optional.<Integer>empty());
        option(optionals);  // output: 8 x 3 = 24
    }

}
