import features.StockAnalyzer;

import java.util.ArrayList;

import static features.StockAnalyzer.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        float[] stockPrices = {106.5f, 21.5f, 8.8f, 2.7f, 54.1f, 89.9f, 99.2f, 53.0f, 2.3f, 33.4f};
        ArrayList<Float> stockPricesList = new ArrayList<>();


        for (float price : stockPrices) {
            stockPricesList.add(price);
        }

        double averagePrice = calculateAveragePrice(stockPrices);
        System.out.println("Average Stock Price: " + averagePrice);

        float maximumPrice = findMaximumPrice(stockPrices);
        System.out.println("Maximum Stock Price: " + maximumPrice);

        float targetPrice = 777.7f;
        int occurrences = countOccurrences(stockPrices, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        ArrayList<Float> cumulativeSum = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}