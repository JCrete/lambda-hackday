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
import java.util.List;

/**
 *  Map-reduce example.
 */
public class Invoice {
    private static final List<Integer> prices = Arrays.asList(10, 15, 20, 25, 30, 45, 50);

    public static void main(String[] args) {
        final double totalOfPricesWithVAT =
                prices.stream().mapToDouble((Integer price) -> price * 1.23).sum();
        System.out.println("Total of prices with VAT 23%: " + totalOfPricesWithVAT);
    }
}
