package com.wipro.tm14_proj3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Card> cardSet = new HashSet<>();
        Map<String, Card> symbolMap = new HashMap<>();

        while (symbolMap.size() < 4) {
            System.out.print("Enter a card (symbol and number): ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String symbol = parts[0];
            int number = Integer.parseInt(parts[1]);

            Card card = new Card(symbol, number);
            cardSet.add(card);
            symbolMap.putIfAbsent(symbol, card);
            System.out.println(cardSet.size() + " cards.");
        }

        List<Card> sortedCards = new ArrayList<>(symbolMap.values());
        sortedCards.sort(Comparator.comparing(card -> card.symbol));

        System.out.println("Cards in Set are:");
        for (Card card : sortedCards) {
            System.out.println(card);
        }
    }
}