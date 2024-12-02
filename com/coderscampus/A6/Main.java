package com.coderscampus.A6;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<SalesSummary> model3Sales = SalesModelsAnalysis.readCSV("model3.csv");
            List<SalesSummary> modelSSales = SalesModelsAnalysis.readCSV("modelS.csv");
            List<SalesSummary> modelXSales = SalesModelsAnalysis.readCSV("modelX.csv");

            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println();

            SalesModelsAnalysis.printYearlySalesReport("Model 3", model3Sales);
            SalesModelsAnalysis.printYearlySalesReport("Model S", modelSSales);
            SalesModelsAnalysis.printYearlySalesReport("Model X", modelXSales);
        } catch (IOException e) {
            e.printStackTrace();}}}
      //  Thank you for reviewing my work and greatly appreciate your valuable input