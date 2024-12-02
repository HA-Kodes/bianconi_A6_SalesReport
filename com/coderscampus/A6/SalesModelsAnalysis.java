package com.coderscampus.A6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.Stream;

public class SalesModelsAnalysis {

    // Method to read CSV files and convert to list of SalesRecord objects
    public static List<SalesSummary> readCSV(String filePath) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1)
                    .map(line -> line.split(","))
                    .map(data -> new SalesSummary(YearMonth.parse(data[0], formatter), Integer.valueOf(data[1])))
                    .collect(Collectors.toList());
        }
    }

    // Method to collect yearly sales
    public static Map<Integer, Integer> getYearlySales(List<SalesSummary> salesSummaries) {
        return salesSummaries.stream()
                .collect(Collectors.groupingBy(record -> record.yearMonth().getYear(), Collectors.summingInt(SalesSummary::sales)));
    }

    // Method to extract the best month
    public static Optional<YearMonth> getBestMonth(List<SalesSummary> salesSummaries) {
        return salesSummaries.stream()
                .max(Comparator.comparingInt(SalesSummary::sales))
                .map(SalesSummary::yearMonth);
    }

    // Method to extract the worst month
    public static Optional<YearMonth> getWorstMonth(List<SalesSummary> salesSummaries) {
        return salesSummaries.stream()
                .min(Comparator.comparingInt(SalesSummary::sales))
                .map(SalesSummary::yearMonth);
    }

    // Method to print the yearly sales report
    public static void printYearlySalesReport(String model, List<SalesSummary> salesSummaries) {
        if (salesSummaries == null || salesSummaries.isEmpty()) {
            System.out.println(model + " has no sales data.");
            return;
        }

        System.out.println(model + " Yearly Sales Report");
        System.out.println("---------------------------");

        Map<Integer, Integer> yearlySales = getYearlySales(salesSummaries);
        yearlySales.forEach((year, sales) -> System.out.println(year + " -> " + sales));

        String bestMonth = getBestMonth(salesSummaries).map(YearMonth::toString).orElse("No data available");
        String worstMonth = getWorstMonth(salesSummaries).map(YearMonth::toString).orElse("No data available");

        System.out.println("\nThe best month for " + model + " was: " + bestMonth);
        System.out.println("The worst month for " + model + " was: " + worstMonth);
        System.out.println();
    }}