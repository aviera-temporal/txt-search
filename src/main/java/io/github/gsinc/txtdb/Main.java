package io.github.gsinc.txtdb;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        FilterField filterField = FilterField.valueOf(args[1]);
        String fieldValue = args[2];
        BufferedReader readable = Files.newReader(new File(filename), Charsets.UTF_8);
        FileProcessor fileProcessor = new FileProcessor(filterField, fieldValue);
        OutputHandler output = new OutputHandler(System.out, Person::toString);
        fileProcessor.processOutput(readable, output);
    }

}