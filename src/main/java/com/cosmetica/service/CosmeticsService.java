package com.cosmetica.service;

import com.cosmetica.bag.CosmeticsBag;
import com.cosmetica.model.Cosmetics;
import com.cosmetica.model.DecorativeCosmetics;
import com.cosmetica.model.Perfumery;
import com.cosmetica.model.SkincareCosmetics;
import lombok.NoArgsConstructor;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@NoArgsConstructor
public class CosmeticsService {
    private final CosmeticsBag bag = new CosmeticsBag();
    private final Scanner scanner = new Scanner(System.in);
    // private final Random random = new Random();


    //добавление нового средства в косметичку
    public void addNewItem() {
        System.out.println("Добавление средства");
        System.out.println("Выберите тип средства:");
        System.out.println("1. Декоративная косметика");
        System.out.println("2. Уходовая косметика");
        System.out.println("3. Парфюмерия");
        System.out.print("Ваш выбор: ");


        int type = scanner.nextInt();
        scanner.nextLine();
        if (type < 1 || type > 3) {
            System.out.println("Неверный тип!");
            return;
        }

        String[] names = getNamesByType(type);

        // название средства
        System.out.println("Доступные названия:");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i]);
        }
        System.out.println("Выберите номер: ");
        int numb = scanner.nextInt();
        scanner.nextLine();

        if (numb < 1 || numb > names.length) {
            System.out.println("Неверный выбор!");
            return;
        }
        String itemName = names[numb - 1];

        //размер
        System.out.println("Введите размер (1-3): ");
        int size = scanner.nextInt();
        scanner.nextLine();
        if (size < 1 || size > 3) {
            System.out.println("Размер должен быть от 1 до 3!");
            return;
        }


        Cosmetics newItem;
        if (type == 1) {
            System.out.println("Выберите качество: ");
            for (int i = 0; i < DecorativeCosmetics.QUALITIES.length; i++) {
                System.out.println((i + 1) + ". " + DecorativeCosmetics.QUALITIES[i]);
            }
            System.out.print("Ваш выбор: ");
            int qualityChoice = scanner.nextInt();
            scanner.nextLine();
            if (qualityChoice < 1 || qualityChoice > DecorativeCosmetics.QUALITIES.length) {
                System.out.println("Неверный выбор качества средства!");
                return;
            }
            newItem = new DecorativeCosmetics(itemName, size, DecorativeCosmetics.QUALITIES[qualityChoice - 1]);
        } else if (type == 2) {
            System.out.println("Выберите качество: ");
            for (int i = 0; i < SkincareCosmetics.QUALITIES.length; i++) {
                System.out.println((i + 1) + ". " + SkincareCosmetics.QUALITIES[i]);
            }
            System.out.print("Ваш выбор: ");
            int qualityChoice = scanner.nextInt();
            scanner.nextLine();
            if (qualityChoice < 1 || qualityChoice > SkincareCosmetics.QUALITIES.length) {
                System.out.println("Неверный выбор качества средства!");
                return;
            }
            newItem = new SkincareCosmetics(itemName, size, SkincareCosmetics.QUALITIES[qualityChoice - 1]);
        } else {
            System.out.println("Выберите аромат: ");
            for (int i = 0; i < Perfumery.AROMA_TYPES.length; i++) {
                System.out.println((i + 1) + ". " + Perfumery.AROMA_TYPES[i]);
            }
            System.out.print("Ваш выбор: ");
            int aromaChoice = scanner.nextInt();
            scanner.nextLine();
            if (aromaChoice < 1 || aromaChoice > Perfumery.AROMA_TYPES.length) {
                System.out.println("Неверный выбор аромата!");
                return;
            }
            newItem = new Perfumery(itemName, size, Perfumery.AROMA_TYPES[aromaChoice - 1]);
        }
        bag.addItem(newItem);
        System.out.println("Средство успешно добавлено!");
    }

    //создание косметички со случайными средствами
    public void createRandomBag() {
        System.out.println("Создание косметички со случайным наполнением");
        System.out.println("Введите количество средств косметички (от 3 до 5) или 0 для случайного выбора: ");
        int count;
        try {
            count = scanner.nextInt();
            scanner.nextLine();
            if (count == 0) {
                count = ThreadLocalRandom.current().nextInt(1, 6);
                System.out.println("Создаём случайную косметичку с " + count + " средствами...");
            } else if (count < 3 || count > 5) {
                System.out.println("Неверный диапазон! Будет выбрано случайное количество средств...");
                count = ThreadLocalRandom.current().nextInt(1, 6);
                System.out.println("Создаём случайную косметичку с " + count + " средствами...");
            } else {
                System.out.println("Выбрано количество: " + count);
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода! Будет выбрано случайное количество средств...");
            scanner.nextLine();
            count = ThreadLocalRandom.current().nextInt(1, 6);
            System.out.println("Создаём случайную косметичку с " + count + " средствами...");
        }
        // добавляем случайные предметы
        for (int i = 0; i < count; i++) {
            int type = ThreadLocalRandom.current().nextInt(1, 4);
            Cosmetics item = createRandomItem(type);
            bag.addItem(item);
        }


    }

    private Cosmetics createRandomItem(int type) {
        String[] names = getNamesByType(type);
        String[] qualities = getQualitiesByType(type);

        String randomName = names[ThreadLocalRandom.current().nextInt(names.length)];
        int randomSize = ThreadLocalRandom.current().nextInt(1, 4);
        String randomQuality = names[ThreadLocalRandom.current().nextInt(names.length)];

        return createCosmeticsByType(type, randomName, randomSize, randomQuality);
    }

    private String[] getNamesByType(int type) {

        if (type == 1) {
            return DecorativeCosmetics.NAMES;
        } else if (type == 2) {
            return SkincareCosmetics.NAMES;
        } else {
            return Perfumery.NAMES;
        }
    }

    private String[] getQualitiesByType(int type) {

        if (type == 1) {
            return DecorativeCosmetics.QUALITIES;
        } else if (type == 2) {
            return SkincareCosmetics.QUALITIES;
        } else {
            return Perfumery.AROMA_TYPES;
        }
    }

    private Cosmetics createCosmeticsByType(int type, String name, int size, String quality) {
        if (type == 1) {
            return new DecorativeCosmetics(name, size, quality);
        } else if (type == 2) {
            return new SkincareCosmetics(name, size, quality);
        } else {
            return new Perfumery(name, size, quality);
        }


    }
}
