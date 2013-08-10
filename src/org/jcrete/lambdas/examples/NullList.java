package org.jcrete.lambdas.examples;

/**
 * ADT ImmutableList: getHead(), getTail(), isEmpty().
 *
 * @param <T> the generic type of the list
 */
public class NullList<T> implements ImmutableListI<T> {
    @Override
    public T getHead()  {
        try {
            throw new NoSuchMethodException("Head is null.");
        } catch (NoSuchMethodException e) {
        }
        return null;
    }

    @Override
    public ImmutableList<T> getTail() {
        try {
            throw new NoSuchMethodException("Tail is null.");
        } catch (NoSuchMethodException e) {
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
