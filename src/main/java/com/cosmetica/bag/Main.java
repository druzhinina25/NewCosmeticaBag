package com.cosmetica.bag;

import com.cosmetica.bag.CosmeticsBag;
import com.cosmetica.model.Cosmetics;
import com.cosmetica.model.DecorativeCosmetics;
import com.cosmetica.model.Perfumery;
import com.cosmetica.model.SkincareCosmetics;
import com.cosmetica.service.CosmeticsService;
import com.cosmetica.service.FileStorage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static CosmeticsService service = new CosmeticsService();
    //очистка консоли
    public static void clearConsole() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
       /* for(int i = 0; i < 50; i++) {
           System.out.println();
       } */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в косметичку!");
        System.out.println("Выберите действие:");
        System.out.println("1. Создать новую косметичку");
        System.out.println("2. Загрузить косметичку из файла");
        System.out.println("Ваш выбор: ");
        int startChoice = scanner.nextInt();
        scanner.nextLine();
        if (startChoice == 1) {
           service.createRandomBag();
        } else if (startChoice == 2){ // загрузить косметичку из файла
            System.out.print("Введите путь к файлу: ");
            String path = scanner.nextLine();
            try {
            service.loadBag(path);
            System.out.println("Косметичка загружена!"); }
            catch (IOException e) {
                System.out.println("Ошибка загрузки: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Неверный выбор!");
            return;
        }
        //главное меню
        while (true) {
            System.out.println("Главное меню:");
            System.out.println("1. Показать содержимое");
            System.out.println("2. Добавить средство");
            System.out.println("3. Удалить средство");
            System.out.println("4. Очистить косметичку");
            System.out.println("5. Сохранить косметичку в файл");
            System.out.println("6. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearConsole();
                    service.showBag();
                    break;
                case 2:
                    clearConsole();
                    //добавить новое средство;
                    service.addNewItem();
                    break;
                case 3:
                    clearConsole();
                    System.out.println("Введите название средства: ");
                    String name = scanner.nextLine();
                    service.removeItem(name);
                    break;
                case 4:
                    clearConsole();
                    service.clearBag();
                    break;
                case 5:
                    clearConsole();
                    System.out.print("Введите путь для сохранения файла: ");
                    String savePath = scanner.nextLine();
                    try {
                        service.saveBag(savePath);
                        System.out.println("Косметичка сохранена!");
                    } catch (IOException e) {
                        System.out.println("Ошибка сохранения: " + e.getMessage());
                    }
                    break;
                case 6:
                    clearConsole();
                    System.out.println("До свидания!");
                    return;
                default:
                    clearConsole(); //очистить консоль
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }


        }
    } }