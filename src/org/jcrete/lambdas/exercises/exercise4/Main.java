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
package org.jcrete.lambdas.exercises.exercise4;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * TODO: Convert printXXX methods to λ.
 */
public class Main {
    private static final List<Member> MEMBERS = init();

    public static void main(String[] args) {
        printMembersOlderThan(MEMBERS, 40);
        printMembersWithinAgeRange(MEMBERS, 35, 40);
        // TODO: Convert to λ
        printMembers(MEMBERS, new CheckMember() {
            @Override
            public boolean test(Member p) {
                return p.getGender() == Member.Sex.FEMALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 30;
            }
        });
    }

    private static final List<Member> init() {
        Member m1 = new Member("John", new GregorianCalendar(1973, 3, 10), Member.Sex.MALE, "nobody@gmail.gr");
        Member m2 = new Member("Maurice", new GregorianCalendar(1975, 5, 1), Member.Sex.MALE, "maurice@gmail.com");
        Member m3 = new Member("Rabea", new GregorianCalendar(1985, 10, 19), Member.Sex.FEMALE, "rabea@yahoo.de");
        return Arrays.asList(m1, m2, m3);
    }

    /**
     * Method that Search for Members that Match One Characteristic
     *
     * TODO: Convert to λ
     *
     * @param roster
     * @param age
     */
    public static void printMembersOlderThan(List<Member> roster, int age) {
        for (Member m : roster) {
            if (m.getAge() >= age) {
                m.printMember();
            }
        }
    }

    /**
     * More Generalized Search Method.
     *
     * TODO: Convert to λ
     *
     * @param roster
     * @param low
     * @param high
     */
    public static void printMembersWithinAgeRange(List<Member> roster, int low, int high) {
        for (Member p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printMember();
            }
        }
    }

    /**
     * Specify Search Criteria Code in an anonymous class
     *
     * TODO: Convert to λ
     *
     * @param members
     * @param tester
     */
    public static void printMembers(List<Member> members, CheckMember tester) {
        for (Member p : members) {
            if (tester.test(p)) {
                p.printMember();
            }
        }
    }

}
