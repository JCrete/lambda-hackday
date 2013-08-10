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
package org.jcrete.lambdas.solutions.exercise3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Convert methods {@code findFirst, deleteFirst} to λ.
 */
public class Products {
    private static final List<Product> PRODUCTS = new ArrayList<>(Arrays.asList(
            new Product("Apple", 0.25),
            new Product("Banana", 1.05),
            new Product("Orange", 0.15),
            new Product("Watermelon", 5.75),
            new Product("Ananas", 4.45)
    ));
    private static final Product NONE = new Product("None", 0.0);

    /**
     * Finds a product that starts with the letter.
     *
     * @param products list of products
     * @param letter   a letter
     * @return the first product found that starts with the letter
     */
    public static Product findFirst(List<Product> products, String letter) {
        final Optional<Product> found = products.stream()
                .filter(product -> product.getName().startsWith(letter))
                .findFirst();
        return found.orElse(NONE);
    }

    /**
     * Deletes the first product that starts with the letter.
     *
     * @param products list of products
     * @param letter   a letter
     * @return the first product found that starts with the letter
     */
    public static Product deleteFirst(List<Product> products, String letter) {
        Product found = findFirst(products, letter);
        return products.remove(found) ? found : NONE;
    }

    public static void main(String[] args) {
        print(PRODUCTS);
        System.out.println(String.format("Found " + Products.findFirst(PRODUCTS, "B") + " starting with B"));
        System.out.println(String.format("Found " + Products.findFirst(PRODUCTS, "Z") + " starting with Z"));
        deleteFirst(PRODUCTS, "B");
        print(PRODUCTS);
    }

    private static void print(List<Product> l) {
        l.forEach(System.out::print);
        System.out.println();
    }

}
