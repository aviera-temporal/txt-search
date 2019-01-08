package io.github.gsinc.txtdb;

import com.google.common.base.Splitter;

import java.util.List;

public class Parser {
    private final Splitter splitter;

    Parser(String separator) {
        splitter = Splitter.on(separator).trimResults();
    }

    public Person parse(String string) {
        List<String> strings = splitter.splitToList(string.substring(1));
        if(strings.size()!=3)
            throw new RuntimeException("Syntax error in line "+string);
        return new Person(strings.get(0), strings.get(1), strings.get(2));
    }
}
