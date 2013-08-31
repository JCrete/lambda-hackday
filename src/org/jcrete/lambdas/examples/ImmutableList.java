package org.jcrete.lambdas.examples;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * ADT ImmutableList: getHead(), getTail(), isEmpty().
 *
 * @param <T> the generic type of the list
 */
public class ImmutableList<T> implements ImmutableListI<T> {
    protected T head;
    protected ImmutableListI<T> tail;

    /**
     * @param x  head
     * @param xs tail
     */
    public ImmutableList(T x, ImmutableListI<T> xs) {
        head = x;
        tail = xs;
    }

    static <T, R> ImmutableList<R> map(Function<T, R> f, ImmutableListI<T> xs) {
        if (xs == null) return null;
        return new ImmutableList<R>(f.apply(xs.getHead()), map(f, xs.getTail()));
    }

    static <A> ImmutableList<A> filter(Predicate<A> f, ImmutableListI<A> xs) {
        if (xs == null) return null;
        if (f.test(xs.getHead()))
            return new ImmutableList<>(xs.getHead(), filter(f, xs.getTail()));
        return filter(f, xs.getTail());
    }

    static <A> int length(ImmutableListI<A> xs) {
        int ans = 0;
        while (xs != null) {
            ++ans;
            xs = xs.getTail();
        }
        return ans;
    }

    @Override
    public T getHead() {
        return head;
    }

    @Override
    public ImmutableListI<T> getTail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

}
