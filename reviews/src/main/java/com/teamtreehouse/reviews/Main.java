package com.teamtreehouse.reviews;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (CSVPrinter printer = new CSVPrinter(System.out, CSVFormat.EXCEL)) {
            printer.printRecord("William", "Gough", 23, "Sick gig!");
            printer.printRecord("Seif", "Kamal", 24, "Yeah boii!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
