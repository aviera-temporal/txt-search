package io.github.gsinc.txtdb;

import java.io.PrintStream;

public class OutputHandler<T> {
    private PrintStream output;
    private boolean first = true;

    public OutputHandler(PrintStream output){
        this.output = output;
    }
    public void beginCollection(){
        output.println("[");
    }

    public void writeObject(T object) {
        if(!first)
            output.println(",");
        output.print("\t" + object.toString());
        first = false;
    }

    public void endCollection(){
        output.println();
        output.println("]");
    }
}
