package org.jcrete.lambdas.examples;

/**
 * ADT ImmutableList: getHead(), getTail(), isEmpty().
 *
 * @param <T> the generic type of the list
 */
public interface ImmutableListI<T> {
    T getHead();

    ImmutableListI<T> getTail();

    boolean isEmpty();
}
