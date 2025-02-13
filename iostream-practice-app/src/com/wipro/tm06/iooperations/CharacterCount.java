package com.wipro.tm06.iooperations;

import java.io.*;
import java.util.Scanner;

public class CharacterCount {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the file name");
            String fileName = scanner.nextLine();

            System.out.println("Enter the character to be counted");
            char ch = scanner.next().charAt(0);

            int count = countCharacterInFile(fileName, ch);

            if (count != -1) {
                System.out.println("File '" + fileName + "' has " + count + " instances of letter '" + ch + "'.");
            }
        }
    }

    public static int countCharacterInFile(String fileName, char ch) {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            char lowerCh = Character.toLowerCase(ch);

            while ((c = reader.read()) != -1) {
                if (Character.toLowerCase((char) c) == lowerCh) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return -1;
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            return -1;
        }

        return count;
    }
}
