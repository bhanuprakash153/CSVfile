package com.example.timingdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CsvFile1 {

    public static void main(String args[]) throws IOException {


        Map<String, String> file1 = new HashMap<>();
        Map<String, String> file2 = new HashMap<>();


        String csvfile1 = "/home/mani/Documents/business.csv";
        String csvfile2 = "/home/mani/Documents/partner.csv";

        Stream<String> newFile = Files.lines(Paths.get(csvfile1));
        Stream<String> newFile1 = Files.lines(Paths.get(csvfile2));

        newFile.forEach(line -> {

            String id = line.split(",")[1];
            String value = line.split(",")[0];
            file1.put(id, value);

            // System.out.println(file1);

        });

        newFile1.forEach(line -> {
            String id = line.split(",")[0];
            String value = line.split(",")[1].replace(",","$$$") + line.split(",")[2];
            file2.put(id, value);
        });


        for (Map.Entry<String, String> entry : file2.entrySet()) {

            String key1 = entry.getKey();
            String value = file1.get(key1);

            String value1 = file2.get(key1);
         //   System.out.println(value +"\n" +  value1);

            System.out.println(value1 );



        }

    }

}

