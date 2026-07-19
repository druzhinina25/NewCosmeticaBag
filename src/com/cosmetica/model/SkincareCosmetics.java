package com.cosmetica.model;

public class SkincareCosmetics extends Cosmetics{
    private String quality;
    public static final String[] NAMES = {"Сыворотка", "Крем", "Патчи"};
    public  static final String[] QUALITIES = {"Обычное", "Люкс", "Профессиональное"};

    public SkincareCosmetics(String name, int size, String quality) {
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
