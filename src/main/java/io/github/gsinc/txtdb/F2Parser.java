package io.github.gsinc.txtdb;

import com.google.common.base.Splitter;

import java.util.List;

class F2Parser implements Parser {
    private static final Splitter splitter = Splitter.on(";").trimResults();

    @Override
    public Person parse(String string) {
        List<String> strings = splitter.splitToList(string.substring(1));
        return new Person(strings.get(0), strings.get(1), strings.get(2));
    }
}
