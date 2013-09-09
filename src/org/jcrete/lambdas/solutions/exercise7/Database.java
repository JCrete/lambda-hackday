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
package org.jcrete.lambdas.solutions.exercise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        List<Book> books = BOOK_DB.stream()
                .filter(book -> book.getTitle().contains("Java"))
                .collect(Collectors.toList());
        print(books, "Books which have the word \"Program\" in the title: ");
        // TODO: Find the titles of books whose author's name is "Bloch"
        List<String> titles = BOOK_DB.stream()
                .filter(book -> book.getAuthors().stream().anyMatch(s -> s.contains("Bloch")))
                .map(Book::getTitle)
                .collect(Collectors.toList());
//        List<String> titles = BOOK_DB.stream().flatMap(book -> book.getAuthors().stream().filter(author -> author.equals("Bloch, Joshua"))).map(b -> b.getTitle()).collect(Collectors.toList());
        print(titles, "Titles of books whose author's name is Bloch: ");
        // TODO: find the names of all authors who have written at least two books
        // Solution contributed by Maurice Naftalin
        List<String> authors = BOOK_DB.stream()
                                      .collect(Collectors.groupingBy(Book::getFirstAuthor))
                                      .entrySet().stream()
                                      .filter(e -> e.getValue().size() > 1)
                                      .map(e -> e.getKey())
                                      .collect(Collectors.toList());
        // Solution contributed by Marc Hoffmann; no need for getFirstAuthor() method
//        List<String> authors = BOOK_DB.stream()
//                                      .flatMap(book -> book.getAuthors().stream())
//                                      .collect(Collectors.groupingBy(author -> author))
//                                      .entrySet().stream()
//                                      .filter(e -> e.getValue().size() > 1)
//                                      .map(e -> e.getKey())
//                                      .collect(Collectors.<String>toList());
        // Another Solution contributed by Maurice Naftalin
//        System.out.println("Names of all authors who have written at least 2 books: ");
//        BOOK_DB.stream()
//                .flatMap(book -> book.getAuthors().stream())
//                .collect(Collectors.toMap(i -> i, a -> 1, (b, c) -> b + c))
//                .entrySet().stream()
//                .filter(e -> e.getValue() > 1)
//                .map(e -> e.getKey())
//                .forEach(System.out::println);
        print(authors, "Names of all authors who have written at least 2 books: ");
        // TODO: sort by author, then by title
        List<Book> bookDBCopy = new ArrayList<>(BOOK_DB);
        // one way
        Function<Book, String> fByAuthor = book -> book.getAuthors().get(0);
        Comparator<Book> byAuthor = Comparator.comparing(fByAuthor);
//        Comparator<Book> byAuthor =  Comparator.comparing((Book book) -> book.getAuthors().get(0));
        // another way
//        Function<Book, String> fByTitle = book -> book.getTitle();
//        Comparator<Book> byTitle =  Comparator.comparing(fByTitle);
        Comparator<Book> byTitle = Comparator.comparing(Book::getTitle);
        bookDBCopy.sort(byAuthor.thenComparing(byTitle));
        print(bookDBCopy, "Sorted by author, then by title");

    }

    private static void print(List<?> l, String msg) {
        System.out.println("\n" + msg);
        l.forEach(System.out::println);
    }
}
