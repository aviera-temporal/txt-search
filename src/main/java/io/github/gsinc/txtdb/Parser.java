package io.github.gsinc.txtdb;

import com.google.common.base.Splitter;

import javax.management.relation.RelationNotFoundException;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    private final Splitter splitter;
    private final Pattern idregex;

    Parser(String separator, String idregex) {
        this.idregex = Pattern.compile(idregex);
        splitter = Splitter.on(separator).trimResults();
    }

    public Person parse(String string) {
        List<String> strings = splitter.splitToList(string.substring(1));
        if(strings.size()!=3)
            throw new RuntimeException("Syntax error in line "+string);

        String id = strings.get(2);
        if(!this.idregex.matcher(id).matches())
            throw new RuntimeException("Syntax error in id " +id);
        return new Person(strings.get(0), strings.get(1), id);
    }
}
