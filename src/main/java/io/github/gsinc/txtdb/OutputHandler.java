package io.github.gsinc.txtdb;

import java.io.PrintStream;
import java.util.function.Function;

public class OutputHandler {
    private PrintStream output;
    private Function<Person, String> objectFormatter;
    private boolean first = true;

    public OutputHandler(PrintStream output, Function<Person, String> objectFormatter){
        this.output = output;
        this.objectFormatter = objectFormatter;
    }
    public void beginCollection(){
        output.println("[");
    }

    public void writeObject(Person object) {
        if(!first)
            output.println(",");
        output.print("\t" + objectFormatter.apply(object));
        first = false;
    }

    public void endCollection(){
        output.println();
        output.println("]");
    }
}
