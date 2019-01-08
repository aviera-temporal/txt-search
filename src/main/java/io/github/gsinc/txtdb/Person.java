package io.github.gsinc.txtdb;

public class Person {
    private final String name;
    private final String city;
    private final String id;

    public Person(String name, String city, String id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }
}
