package com.pawelzabczynski.resourceLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceLoader {
    private String filePath = "/resources";

    public ResourceLoader(String fileName) {
        this.filePath = new java.io.File("src\\main\\resources\\" + fileName).getAbsolutePath();
        System.out.println(this.filePath);
    }

    public String loadFile() {
        String result = "";

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.filePath));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                result += sCurrentLine;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public String getFilePath() {
        return filePath;
    }
}
