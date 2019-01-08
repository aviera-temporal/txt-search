package io.github.gsinc.txtdb;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class LineProcessor {
    private Format format;
    private static Map<Format, Parser> formatToParser = ImmutableMap.of(Format.F1, new Parser(",", "\\d{8}[A-Z]"), Format.F2, new Parser(" ; ", "\\d{8}-[A-Z]"));

    public void setFormat(Format format) {
        this.format = format;
    }

    public Person processLine(String line) {
        return formatToParser.get(format).parse(line);
    }

    public enum Format {
        F1,
        F2;
    }

}
