package io.github.gsinc.txtdb;

import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor {
    private FilterField filterField;
    private String fieldValue;
    private static boolean first = true;

    public FileProcessor(FilterField filterField, String fieldValue) {
        this.filterField = filterField;
        this.fieldValue = fieldValue;
    }

    public void processOutput(BufferedReader readable) throws IOException {
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
                    if(this.fieldValue.equals(this.filterField.getExtractor().apply(person))){
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
