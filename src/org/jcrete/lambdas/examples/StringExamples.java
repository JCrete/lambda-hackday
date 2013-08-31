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

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class StringExamples {
    private static final String str = "Hawk1";

    public static void main(String[] args) {
        str.chars().forEach(ch -> System.out.print(ch));
//        str.chars().forEach(IterateString::printChar);
        System.out.println();
        str.chars().forEach(System.out::print);
        System.out.println();
        str.chars().map(ch -> Character.valueOf((char) ch))
                .forEach(System.out::print);
//        str.chars().filter(ch -> Character.isDigit(ch))
//                .forEach(ch -> printChar(ch));
//        str.chars().filter(Character::isDigit)
//                .forEach(IterateString::printChar);
    }

}
