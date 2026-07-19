package com.cosmetica.model;

public abstract class Cosmetics {
    private String name;
    private int size;

    public Cosmetics(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "название: " + name + ", размер: " + size;
    }
}
