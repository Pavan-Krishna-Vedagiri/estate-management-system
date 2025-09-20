package com.pavan.github.estatemanagementsystem.modals;

public class PG {

    private String Id;
    private String name;

    public PG(){}

    public PG(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PG{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
