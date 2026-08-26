package com.cosmetica.bag;

import com.cosmetica.bag.CosmeticsBag;
import com.cosmetica.model.Cosmetics;
import com.cosmetica.model.DecorativeCosmetics;
import com.cosmetica.model.Perfumery;
import com.cosmetica.model.SkincareCosmetics;
import com.cosmetica.service.CosmeticsService;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        CosmeticsBag myBag = null;
        System.out.println("Добро пожаловать в косметичку!");
        System.out.println("Выберите действие:");
        System.out.println("1. Создать новую косметичку");
        System.out.println("2. Загрузить косметичку из файла");
        int startChoice = scanner.nextInt();
        scanner.nextLine();
        if (startChoice == 1) {
           service.createRandomBag();
        } else { // загрузить косметичку из файла
            System.out.println("Загрузка косметички из файла");

        }

        //главное меню
        while (true) {
            System.out.println("Главное меню:");
            System.out.println("1. Показать содержимое");
            System.out.println("2. Добавить средство");
            System.out.println("3. Удалить средство");
            System.out.println("4. Очистить косметичку");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearConsole();
                    myBag.showContents();
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
                    myBag.removeObject(name);
                    break;
                case 4:
                    clearConsole();
                    myBag.clear();
                    break;
                case 5:
                    clearConsole();
                    System.out.println("До свидания!");
                    break;
                default:
                    clearConsole(); //очистить консоль
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }


        }
    } }