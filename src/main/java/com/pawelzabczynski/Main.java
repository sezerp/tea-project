package com.pawelzabczynski;

import com.pawelzabczynski.resourceLoader.CsvToDevice;
import java.util.ArrayList;

public class Main {
    static final String CONFIG = "config";
    static final String CSV_DATA = "MOCK_DATA-2.csv";

    public static void main(String[] args) {
        CsvToDevice csvToDevice = new CsvToDevice(CSV_DATA);
        ArrayList<String> listOfHeaders = csvToDevice.getHeaderList();
        for(String s: listOfHeaders) {
            System.out.print(s + " ");
        }
        System.out.println();
        csvToDevice.getDevicesList();
    }
}