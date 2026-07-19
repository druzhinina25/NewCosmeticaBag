package com.cosmetica.bag;


import com.cosmetica.model.Cosmetics;
import java.util.ArrayList;
import java.util.List;

public class CosmeticsBag {
    //поля: вместимость, средства
    private int capacity;
    private List<Cosmetics> objects;

    //конструктор - создаётся объект
    public CosmeticsBag(int capacity) {
        this.capacity = capacity;
        this.objects = new ArrayList<>();
    }
    public int getCapacity() {
        return capacity;
    }
    public List<Cosmetics> getMeans() {
        return objects;
    }
    // доп методы
    //занятый объём
    public int getOccupiedVolume() {
        int volume = 0;
        for(Cosmetics object : objects){
            volume = volume + object.getSize();
        }
        return volume;
    }

    //методы : положить, достать, очистить
    public void addObject(Cosmetics object) {
        int occupiedVolume = getOccupiedVolume();
        if(occupiedVolume + object.getSize()  <= capacity) {
            objects.add(object);
            System.out.println("средство" + object.getName() + " добавлено");
        }
        else {
            System.out.println("средство" + object.getName() + " не добавлено, так как нет места" );
        }
    }
    public Cosmetics removeObject(String name) {
        for(Cosmetics object : objects) {
            if(object.getName().equalsIgnoreCase(name)){
                objects.remove(object);
                System.out.println("средство" + name + " удалено");
                return object;
            }
           // else{
            //    System.out.println("ошибка");
              //  return null;
            }
        return null;
        }

    public void clear() {
        objects.clear();
        System.out.println("косметичка пуста");
    }
// метод, показывающий содержимое
    public void showContents() {
        System.out.println("Заполнено: " + getOccupiedVolume() + "/" + capacity );
        if(objects.isEmpty()) {
            System.out.println("Косметичка пуста!");
        } else {
            System.out.println("Содержимое:");
            for(int i = 0; i < objects.size(); i++) {
                System.out.println((i + 1) + ". " + objects.get(i));
            }
        }
    }
}
