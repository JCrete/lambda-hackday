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
package org.jcrete.lambdas.solutions.exercise6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * List files in a Directory of a specific type.
 */
public class ListFiles {

    /**
     * List files of specific type in a directory.
     *
     * @param aPath a directory
     * @param type file type (e.g. ".java")
     * @return a list of file names of the given type.
     */
    private static void listFiles(String aPath, String type) throws IOException {
        Files.newDirectoryStream(Paths.get(aPath), path -> path.toString().endsWith(type)).forEach(System.out::println);
    }

    /**
     * List hidden files in a directory.
     *
     * @param aPath a directory
     * @return list of hidden files
     */
    private static List<File> listHiddenFiles(String aPath) {
        return Arrays.asList(new File(aPath).listFiles(File::isHidden));
//        return Arrays.asList(new File(aPath).listFiles(file -> file.isHidden()));
    }

    /**
     * List sub-directories of directory {@code aPath}.
     *
     * @param aPath a directory
     */
    private static void listDirectories(String aPath) {
        try {
//            Files.newDirectoryStream(Paths.get(aPath), Path::toFile::isDirectory()).forEach(System.out::println);
            Files.newDirectoryStream(Paths.get(aPath), path -> path.toFile().isDirectory()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            listFiles("src/org/jcrete/lambdas/examples", ".java");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nHidden files: ");
        print(listHiddenFiles("src/org/jcrete/lambdas/examples"));
        System.out.println("\nSub-directories:");
        listDirectories("src/org/jcrete/lambdas/examples");
    }

    private static void print(List<?> list) {
        list.forEach(name -> System.out.print("" + name + " "));
        System.out.println();
    }

}
