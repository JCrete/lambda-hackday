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
package org.jcrete.lambdas.exercises.exercise6;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

/**
 * List files in a Directory of a specific type.
 */
public class ListFiles {

    /**
     * List files of specific type in a directory.
     *
     * TODO: Convert it to λ. Hint: use Files.newDirectoryStream().
     *
     * @param path a directory
     * @param type file type (e.g. ".java")
     * @return a list of file names of the given type.
     */
    private static String[] listFiles(String path, String type) {
        return new File(path).list(new FilenameFilter() {
            @Override
            public boolean accept(final File dir, final String name) {
                return name.endsWith(type);
            }
        });
    }

    /**
     * List hidden files.
     *
     * TODO: Convert it to λ
     *
     * @param aPath a directory
     * @return a list of hidden files
     */
    private static List<File> listHiddenFiles(String aPath) {
        return Arrays.asList(new File(aPath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        }));
    }

    /**
     * List sub-directories of directory {@code aPath}.
     *
     * TODO: Convert it to λ. Hint: use Files.newDirectoryStream(). Change
     * signature to {@code private static void listDirectories(String aPath)}
     *
     * @param aPath a directory
     */
    private static List<File> listDirectories(String aPath) {
        return Arrays.asList(new File(aPath).listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        }));
    }

    public static void main(String[] args) {
        // TODO: You might need to modify this part
        String[] javaFiles = listFiles("src/org/jcrete/lambdas/examples", ".java");
        for (String javaFile : javaFiles) {
            System.out.println(javaFile);
        }
        System.out.println("\nHidden files: ");
        print(listHiddenFiles("src/org/jcrete/lambdas/examples"));
        System.out.println("\nSub-directories: ");
        // TODO: will become listDirectories("src/org/jcrete/lambdas/examples");
        print(listDirectories("src/org/jcrete/lambdas/examples"));
    }

    private static void print(List<?> list) {
        list.forEach(name -> System.out.print("" + name + " "));
        System.out.println();
    }

}
