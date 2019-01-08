package io.github.gsinc.txtdb;

import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor {
    private FilterField filterField;
    private String fieldValue;

    public FileProcessor(FilterField filterField, String fieldValue) {
        this.filterField = filterField;
        this.fieldValue = fieldValue;
    }

    public void processOutput(BufferedReader readable, OutputHandler<Person> output) throws IOException {
        String line = readable.readLine();
        LineProcessor lineProcessor = new LineProcessor();
        output.beginCollection();
        while (line != null) {
            switch (line) {
                case "F1":
                    lineProcessor.setFormat(LineProcessor.Format.F1);
                    break;
                case "F2":
                    lineProcessor.setFormat(LineProcessor.Format.F2);
                    break;
                default:
                    Person person = lineProcessor.processLine(line);
                    if (this.fieldValue.equals(this.filterField.getExtractor().apply(person))) {
                        output.writeObject(person);
                    }
                    break;
            }
            line = readable.readLine();
        }
        output.endCollection();
    }
}
