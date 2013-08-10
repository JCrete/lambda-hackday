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
package org.jcrete.lambdas.exercises.exercise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model.
 *
 * @author jkost
 */
public class Database {
    private static final List<Book> BOOK_DB = Arrays.asList(
            new Book("Mastering Lambdas", Arrays.asList("Naftalin, Maurice")),
            new Book("Functional Programming in Java", Arrays.asList("Subramaniam, Venkat")),
            new Book("Effective Java", Arrays.asList("Bloch, Joshua")),
            new Book("Java Puzzlers", Arrays.asList("Bloch, Joshua", "Gafter, Neal")),
            new Book("Programming in Scala", Arrays.asList("Odersky, Martin", "Spoon, Lex", "Venners, Bill")));

    public static void main(String[] args) {
        // TODO: find all the books which have the word "Java" in the title
        List<Book> books = new ArrayList<>();
        print(books, "Books which have the word \"Program\" in the title");
        // TODO: Find the titles of books whose author's name is Bloch
        List<String> titles = new ArrayList<>();
        print(titles, "Titles of books whose author's name is Bloch");
        // TODO: find the names of all authors who have written at least two books
        List<String> authors = new ArrayList<>();
        print(authors, "Names of all authors who have written at least 2 books");
    }

    private static void print(List<?> l, String msg) {
        System.out.println("\n" + msg);
        l.forEach(System.out::println);
    }
}
