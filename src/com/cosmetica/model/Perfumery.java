package com.cosmetica.model;

public class Perfumery extends Cosmetics {
    private String type;
    public static final String[] NAMES = {"Туалетная вода", "Духи"};
    public  static final String[] AROMA_TYPES = {"Цветочный", "Древесный", "Свежий"};

    public Perfumery(String name, int size, String type){
        super(name, size);
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setType() {
        this.type = type;
    }
    @Override
    public String toString() {
        return "название: " + getName() + ", размер: " + getSize() + ", тип аромата: " + type;
    }

}
