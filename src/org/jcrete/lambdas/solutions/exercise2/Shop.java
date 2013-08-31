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
package org.jcrete.lambdas.solutions.exercise2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * Convert methods {@code filter, sum, applyTax} to λ.
 */
public class Shop {
    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product("Apple", 0.25),
            new Product("Banana", 1.05),
            new Product("Orange", 0.15),
            new Product("Watermelon", 5.75),
            new Product("Ananas", 4.45)
    );

    public static List<Product> filter(List<Product> products, double minPrice, double maxPrice) {
        return Collections.unmodifiableList(products.stream().filter(p -> p.getPrice() > minPrice && p.getPrice() < maxPrice).collect(Collectors.<Product>toList()));
        // Collectors.toUnmodifiableList() ?
    }

    public static double sum(List<Product> products) {
        return products.stream().mapToDouble(p -> p.getPrice()).sum();
    }

    public static double applyTax(List<Product> products, Tax<Product> tax) {
//        return products.stream().mapToDouble(p -> tax.applyTax(p)).sum();
        // using method reference
        return products.stream().mapToDouble(tax::applyTax).sum();
        // Solution contributed by Andres Almiray
//        return products.stream().map(tax::applyTax).reduce(0d, Double::sum);
    }

    // Why not total(ImmutableList<Product> products, Function<Product, Double> f)  ???
    public static double total(List<Product> products, ToDoubleFunction<Product> f) {
        return products.stream().mapToDouble(f).sum();
    }

    public static void main(String[] args) {
        System.out.println("Filter:");
        List<Product> filtered = filter(PRODUCTS, 1.00, 5.00);
        System.out.println(filtered);

        System.out.print("Net price   : ");
        double sum = sum(filtered);
        System.out.printf("%.2f€\n", sum);

        System.out.print("Net price   : ");
        sum = total(filtered, p -> p.getPrice());
        System.out.printf("%.2f€\n", sum);

        System.out.print("Total to pay: ");
        double toPay = applyTax(filtered, p -> p.getPrice() * 1.23);
        System.out.printf("%.2f€\n", toPay);

        System.out.print("Total to pay: ");
        toPay = total(filtered, p -> p.getPrice() * 1.23);
        System.out.printf("%.2f€", toPay);
    }
}
