package org.vital.bootproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
/*import com.sun.istack.internal.NotNull;*/

public class Person {
    private int id;

    /*@NotNull*/
    private String name;

    public Person(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
