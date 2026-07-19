package com.cosmetica.model;

public class DecorativeCosmetics extends Cosmetics{
    private String quality;
    public static final String[] NAMES = {"Тональный крем", "Тени", "Помада"};
    public  static final String[] QUALITIES = {"Обычное", "Люкс", "Профессиональное"};

    public DecorativeCosmetics(String name, int size, String quality) {
        super(name, size);
        this.quality = quality;
    }
    public String getQuality() {
        return quality;
    }
    public void setQuality(){
        this.quality = quality;
    }
    @Override
    public String toString() {
        return  "название: " + getName() + ", размер: " + getSize() + ", качество: " + quality;
    }
}
