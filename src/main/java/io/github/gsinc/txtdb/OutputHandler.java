package io.github.gsinc.txtdb;

import java.io.PrintStream;
import java.util.function.Function;

public class OutputHandler<T> {
    private PrintStream output;
    private Function<T, String> objectFormatter;
    private boolean first = true;

    public OutputHandler(PrintStream output, Function<T, String> objectFormatter){
        this.output = output;
        this.objectFormatter = objectFormatter;
    }
    public void beginCollection(){
        output.println("[");
    }

    public void writeObject(T object) {
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
