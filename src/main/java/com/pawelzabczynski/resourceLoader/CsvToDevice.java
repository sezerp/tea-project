package com.pawelzabczynski.resourceLoader;

import com.pawelzabczynski.Models.Device;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class CsvToDevice extends ResourceLoader {

    private Device device;
    private Reader fileContent;
    private Iterable<CSVRecord> csvRecords;

    public CsvToDevice(String fileName) {
        super(fileName);
        this.setFileContent();
        this.getRecords();
        device = new Device();
    }

    public Iterable<CSVRecord> getRecords() {

        try {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(this.fileContent);
            this.csvRecords = records;
            return records;
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        return  null;
    }

    public ArrayList<Device> getDevicesList() {
        ArrayList<String> devices = new ArrayList<>();
        int i = 0;
        for(CSVRecord r: this.getRecords()) {

        }
        return null;
    }

    public ArrayList<String> getHeaderList() {
        ArrayList<String> buffHeader = new ArrayList<>();
        CSVRecord record = null;
        int columns = 0;
        for(CSVRecord r: this.csvRecords) {
            record = r;
            columns = r.size();
            break;
        }
        if(record != null) {
            for(int i = 0; i < columns; i++) {
                buffHeader.add(record.get(i));
            }
            return buffHeader;
        }
        return null;
    }

    public void setFileContent() {
        try {
            this.fileContent = new FileReader(super.getFilePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
