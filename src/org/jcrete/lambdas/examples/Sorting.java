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

/**
 * The quick sort implementation.
 */
public class Sorting<T> {
    private static final List<Integer> LIST = Arrays.asList(3, 5, 9, -2, 1, 6, 9);

    public static <T extends Comparable<T>> void qsort(List<T> list, int left, int right, Comparator<T> comparator) {
        int last = left;
        // do nothing if the list contains fewer than two elements
        if (left >= right) return;
        swap(list, left, (left + right) / 2);
        for (int i = left + 1; i < right; i++) {
            if (comparator.compare(list.get(i), list.get(left)) < 0) {
                swap(list, ++last, i);
            }
        }
        swap(list, left, last);
        qsort(list, left, last - 1, comparator);
        qsort(list, last + 1, right, comparator);

//        // Get the pivot element from the middle of the list
//        T pivot = list.get(left + (right - left) / 2);
//        // Divide into two lists
//        while (i <= j) {
//            // If the current value from the left list is smaller then the pivot
//            // element then get the next element from the left list
//            while (comparator.compare(list.get(i), pivot) < 0) {
//                i++;
//            }
//            // If the current value from the right list is larger then the pivot
//            // element then get the next element from the right list
//            while (comparator.compare(list.get(j),pivot) > 0) {
//                j--;
//            }
//
//            // If we have found a value in the left list which is larger then
//            // the pivot element and if we have found a value in the right list
//            // which is smaller than the pivot element then we swap the values.
//            // As we are done we can increase i and decrease j
//            if (i <= j) {
//                swap(list, i, j);
//                i++;
//                j--;
//            }
//        }
//        // Recursion
//        if (left < j)
//            qsort(list, left, j, comparator);
//        if (i < right)
//            qsort(list, i, right, comparator);
    }

    private static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        print(LIST, "Unsorted...");
        qsort(LIST, 0, LIST.size(), (Integer a, Integer b) -> a.compareTo(b));
        print(LIST, "Sorted...");
//        qsort(LIST, 0, LIST.size(), (int a, int b) -> comparator.compare(String.valueOf(a), (String.valueOf(b))));
    }


    private static <T> void print(List<T> l, String msg) {
        System.out.println("\n" + msg);
        l.forEach(i -> {
            System.out.print(i);
            System.out.print(" ");
        });
    }
}
