package io.github.gsinc.txtdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class FileProcessor {
    private FilterField filterField;
    private String fieldValue;
    private static boolean first = true;

    public FileProcessor(FilterField filterField, String fieldValue) {
        this.filterField = filterField;
        this.fieldValue = fieldValue;
    }

    public void processOutput(BufferedReader readable, PrintStream output) throws IOException {
        String line = readable.readLine();
        LineProcessor lineProcessor = new LineProcessor();
        output.println("[");
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
                            output.println(",");
                        output.print("\t" + person);
                        first = false;
                    }
                    break;
            }
            line = readable.readLine();
        }
        output.println();
        output.println("]");
    }
}
