package io.github.gsinc.txtdb;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public enum FilterField  {
    CITY(Person::getCity),
    ID(Person::getId);

    public Function<Person, String> getExtractor() {
        return extractor;
    }

    private Function<Person, String> extractor;
    FilterField(Function<Person, String> extractor){
        this.extractor = extractor;
    }
}
