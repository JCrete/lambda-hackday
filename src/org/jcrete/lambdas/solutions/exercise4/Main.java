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
package org.jcrete.lambdas.solutions.exercise4;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Convert printXXX methods to λ.
 */
public class Main {
    private static final List<Member> MEMBERS = init();

    public static void main(String[] args) {
        printMembersOlderThan(MEMBERS, 40);
        printMembersWithinAgeRange(MEMBERS, 35, 40);
        printMembers(MEMBERS,
                m -> m.getGender() == Member.Sex.FEMALE &&
                m.getAge() >= 18 &&
                m.getAge() <= 30);
        printMembers2(MEMBERS,
                m -> m.getGender() == Member.Sex.FEMALE &&
                m.getAge() >= 18 &&
                m.getAge() <= 30,
                m -> m.printMember());
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
     * @param members
     * @param age
     */
    public static void printMembersOlderThan(List<Member> members, int age) {
        members.stream().filter(m -> m.getAge() >= age).forEach(m -> m.printMember());
//        for (Member m : roster) {
//            if (m.getAge() >= age) {
//                m.printMember();
//            }
//        }
    }

    /**
     * More Generalized Search Method.
     *
     * @param roster
     * @param low
     * @param high
     */
    public static void printMembersWithinAgeRange(List<Member> roster, int low, int high) {
        roster.stream().filter(m -> m.getAge() >= low && m.getAge() < high).forEach(m -> m.printMember());
//        for (Member p : roster) {
//            if (low <= p.getAge() && p.getAge() < high) {
//                p.printMember();
//            }
//        }
    }

    /**
     * Specify Search Criteria Code in an anonymous class
     *
     * @param roster
     * @param tester
     */
    public static void printMembers(List<Member> roster, Predicate<Member> tester) {
        roster.stream().filter(tester).forEach(m -> m.printMember());
//        for (Member p : roster) {
//            if (tester.test(p)) {
//                p.printMember();
//            }
//        }
    }

    /**
     * Specify Search Criteria Code in an anonymous class
     *
     * @param roster
     * @param tester
     */
    public static void printMembers2(List<Member> roster, Predicate<Member> tester, Consumer<Member> block) {
        for (Member p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }


}
