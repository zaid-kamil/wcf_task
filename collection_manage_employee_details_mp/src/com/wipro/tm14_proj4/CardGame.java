package com.wipro.tm14_proj4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Cards: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumes newline

        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter card " + (i + 1) + ": ");
            String cardInput = scanner.nextLine();
            String symbol = cardInput.substring(0, 1);
            int number = Integer.parseInt(cardInput.substring(1));
            cards.add(new Card(symbol, number));
        }

        Map<String, List<Card>> cardMap = new HashMap<>();
        for (Card card : cards) {
            cardMap.computeIfAbsent(card.symbol, k -> new ArrayList<>()).add(card);
        }

        List<String> distinctSymbols = new ArrayList<String>(cardMap.keySet());
        Collections.sort(distinctSymbols);
        System.out.println("Distinct Symbols are: " + String.join(" ", distinctSymbols));

        for (String symbol : distinctSymbols) {
            System.out.println("Cards in " + symbol + " Symbol");
            int totalSum = 0;
            for (Card card : cardMap.get(symbol)) {
                System.out.println(card.symbol + " " + card.number);
                totalSum += card.number;
            }
            System.out.println("Number of cards: " + cardMap.get(symbol).size());
            System.out.println("Sum of Numbers: " + totalSum);
        }

        scanner.close();
    }
}