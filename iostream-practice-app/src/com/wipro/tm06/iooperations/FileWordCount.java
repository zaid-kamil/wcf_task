package com.wipro.tm06.iooperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileWordCount {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileWordCount inputFile.txt outputFile.txt");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        // TreeMap to automatically sort the keys alphabetically
        Map<String, Integer> wordCountMap = new TreeMap<>();

        // Read the file and count words
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error occurred while reading the input file: " + e.getMessage());
            System.exit(1);
        }

        // Write the sorted word counts to the output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                bw.write(entry.getKey() + " : " + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error occurred while writing to the output file: " + e.getMessage());
            System.exit(1);
        }
    }
}
