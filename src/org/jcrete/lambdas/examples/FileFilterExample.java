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

import java.io.File;
import java.io.FileFilter;

/**
 * Convert anonymous classes to lambdas
 */
public class FileFilterExample {

    public static void main(String[] args) {
        fileFilter(".");
        System.out.println();
        fileFilterLambdas("..");
        System.out.println();
        fileFilterLambdas2("../..");
    }

    private static void fileFilter(String path) {
        File dir = new File(path);
        FileFilter directoryFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] directories = dir.listFiles(directoryFilter);
        print(directories);
    }

    private static void fileFilterLambdas(String path) {
        File dir = new File(path);
        FileFilter directoryFilter = (File f) -> f.isDirectory();
        File[] directories = dir.listFiles(directoryFilter);
        print(directories);
    }

    private static void fileFilterLambdas2(String path) {
        File dir = new File(path);
        File[] directories = dir.listFiles(f -> f.isDirectory());
        print(directories);
    }

    private static void print(File[] dirs) {
        for (File dir : dirs) {
            System.out.println(dir.getName());
        }
    }

}
