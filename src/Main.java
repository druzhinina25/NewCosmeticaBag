import com.cosmetica.bag.CosmeticsBag;
import com.cosmetica.model.Cosmetics;
import com.cosmetica.model.DecorativeCosmetics;
import com.cosmetica.model.Perfumery;
import com.cosmetica.model.SkincareCosmetics;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Random RANDOM = new Random();
    //очистка консоли
    public static void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    //добавление нового средства в косметичку
    private static void addNewObject(CosmeticsBag bag) {
        System.out.println("Добавление средства");
        System.out.println("Выберете тип средства:");
        System.out.println("1. Декоративная косметика");
        System.out.println("2. Уходовая косметика");
        System.out.println("3. Парфюмерия");
        System.out.print("Ваш выбор: ");

        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        scanner.nextLine();
        if (type < 1 || type > 3) {
            System.out.println("Неверный тип!");
            return; }
        String[] names;
        if (type == 1) {
            names = DecorativeCosmetics.NAMES;
        } else if(type == 2) {
            names = SkincareCosmetics.NAMES;
        } else {
            names = Perfumery.NAMES; }

        // название средства
        System.out.println("Достурные названия:");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i+1) + ". " + names[i]);
        }
        System.out.println("Выберете номер: ");
        int numb = scanner.nextInt();
        scanner.nextLine();

        if(numb < 1 || numb > names.length) {
            System.out.println("Неверный выбор!");
            return;
        }
        String objectName = names[numb-1];

        //размер
        System.out.println("Введите размер (1-3): ");
        int size = scanner.nextInt();
        scanner.nextLine();
        if (size < 1 || size > 3) {
            System.out.println("Размер должен быть от 1 до 3!");
            return;
        }
        Cosmetics newObj;
        if (type == 1) {
            System.out.println("Выберете качество: ");
            for(int i = 0; i < DecorativeCosmetics.QUALITIES.length; i++) {
                System.out.println((i+1) + ". " + DecorativeCosmetics.QUALITIES[i]);
            }
            System.out.print("Ваш выбор: ");
            int qualityChoice = scanner.nextInt();
            scanner.nextLine();
            if(qualityChoice < 1 || qualityChoice > DecorativeCosmetics.QUALITIES.length) {
                System.out.println("Неверный выбор качества средства!");
                return;
            }
            newObj = new DecorativeCosmetics(objectName,size,DecorativeCosmetics.QUALITIES[qualityChoice - 1]);
        } else if(type == 2) {
            System.out.println("Выберете качество: ");
            for(int i = 0; i < SkincareCosmetics.QUALITIES.length; i++) {
                System.out.println((i+1) + ". " + SkincareCosmetics.QUALITIES[i]);
            }
            System.out.print("Ваш выбор: ");
            int qualityChoice = scanner.nextInt();
            scanner.nextLine();
            if(qualityChoice < 1 || qualityChoice > SkincareCosmetics.QUALITIES.length) {
                System.out.println("Неверный выбор качества средства!");
                return;
            }
            newObj = new SkincareCosmetics(objectName, size, SkincareCosmetics.QUALITIES[qualityChoice-1]);
        } else {
            System.out.println("Выберете аромат: ");
            for(int i = 0; i < Perfumery.AROMA_TYPES.length; i++) {
                System.out.println((i+1) + ". " + Perfumery.AROMA_TYPES[i]);
            }
            System.out.print("Ваш выбор: ");
            int aromaChoice = scanner.nextInt();
            scanner.nextLine();
            if(aromaChoice < 1 || aromaChoice > Perfumery.AROMA_TYPES.length) {
                System.out.println("Неверный выбор аромата!");
                return;
            }
            newObj = new Perfumery(objectName, size, Perfumery.AROMA_TYPES[aromaChoice - 1]);
        }
        bag.addObject(newObj);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CosmeticsBag myBag = null;
        System.out.println("Добро пожаловать в косметичку!");
        System.out.println("Выберете действие:");
        System.out.println("1. Создать новую косметичку");
        System.out.println("2. Загрузить косметичку из файла");
        int startChoice = scanner.nextInt();
        scanner.nextLine();
        if (startChoice == 1) {
            // новая косметичка со случайным наполнением

            // рандом
        } else { // загрузить косметичку из файла
            System.out.println("Загрузка косметички из файла");

        }

        //главное меню
        while (true) {
            System.out.println("Главное меню:");
            System.out.println("1. Показать сдержимое");
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
                    addNewObject(myBag);
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