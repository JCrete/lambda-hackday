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
package org.jcrete.lambdas.exercises.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    // TODO: Convert it to λ-expression
    public static List<Product> filter(List<Product> products, double minPrice, double maxPrice) {
        List<Product> filtered = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() > minPrice && p.getPrice() < maxPrice) {
                filtered.add(p);
            }
        }
        return Collections.unmodifiableList(filtered);
    }

    // TODO: Convert it to λ-expression
    public static double sum(List<Product> products) {
        double s = 0.0;
        for (Product p : products) {
            s += p.getPrice();
        }
        return s;
    }

    // TODO: Convert it to λ-expression
    public static double applyTax(List<Product> products, Tax<Product> tax) {
        double s = 0.0;
        for (Product p : products) {
            s += tax.applyTax(p);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println("Filter:");
        List<Product> filtered = filter(PRODUCTS, 1.00, 5.00);
        System.out.println(filtered);

        System.out.print("Net price  : ");
        double sum = sum(filtered);
        System.out.printf("%.2f€\n", sum);

        System.out.print("Total to pay: ");
        // TODO: Convert it to λ
        double toPay = applyTax(filtered, new Tax<Product>() {

            @Override
            public double applyTax(Product t) {
                return t.getPrice() * 1.23;   // tax in Greece is 23% (year 2013)
            }
        });
        System.out.printf("%.2f€", toPay);
    }
}
