package com.coderscampus.A6;

import java.time.YearMonth;

public record SalesSummary(YearMonth yearMonth, Integer sales) { //Java suggested this shortcut
}
// based on my work as follows:
// public class SalesRecord {
//    private final YearMonth yearMonth;
//    private final Integer sales;
//
//    public SalesRecord(YearMonth yearMonth, Integer sales) {
//        this.yearMonth = yearMonth;
//        this.sales = sales;
//    }
//
//    // Getters
//    public YearMonth getYearMonth() {
//        return yearMonth;
//    }
//
//    public Integer getSales() {
//        return sales;
//    }
//}

// curious which method is better / more commonly written
