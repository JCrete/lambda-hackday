package org.jcrete.lambdas.examples;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Uses org.jcrete.lambdas.examples.ImmutableList
 */
public class ListExample {

    static ImmutableList<Integer> doubleAll(ImmutableList<Integer> xs) {
        return ImmutableList.map((new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * 2;
            }
        }), xs);
    }

    static int countNs(ImmutableList<Integer> xs, final int n){
        return ImmutableList.length(ImmutableList.filter((new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x == n;
            }
        }), xs));
    }

    public static void main(String[] args) {
        ImmutableListI<Integer> list = new ImmutableList<>(1, new NullList<Integer>());
    }
}
