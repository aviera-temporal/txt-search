package io.github.gsinc.txtdb;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Main {
    private static boolean first = true;

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FilterField filterField = FilterField.valueOf(args[1]);
        String fieldValue = args[2];
        BufferedReader readable = Files.newReader(new File(filename), Charsets.UTF_8);


        doProcessing(filterField, fieldValue, readable);
    }

    @VisibleForTesting
    static void doProcessing(FilterField filterField, String fieldValue, BufferedReader readable) throws IOException {
        String line = readable.readLine();
        LineProcessor lineProcessor = new LineProcessor();
        System.out.println("[");
        while(line!=null){
            switch (line){
                case "F1":
                    lineProcessor.setFormat(LineProcessor.Format.F1);
                    break;
                case "F2":
                    lineProcessor.setFormat(LineProcessor.Format.F2);
                    break;
                default:
                    Person person = lineProcessor.processLine(line);
                    if(fieldValue.equals(filterField.getExtractor().apply(person))){
                        if(!first)
                            System.out.println(",");
                        System.out.print("\t" + person);
                        first = false;
                    }
                    break;
            }
            line = readable.readLine();
        }
        System.out.println();
        System.out.println("]");
    }
}