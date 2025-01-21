import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private static Scanner scan = new Scanner(System.in);
    private static List<String> tasks = new ArrayList<>();

    private static void showMenu() {
        System.out.print("Выберите операцию:\n" +
                "\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дело по ключевому слову\n" +
                "Ваш выбор: ");
    }

    private static void addTask() {
        System.out.println();
        System.out.print("Введите название задачи: ");
        String task = scan.nextLine();
        tasks.add(task);
        System.out.println("Добавлено!");
    }

    private static void showTasks() {
        System.out.println("Ваш список дел: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
        System.out.println();
    }

    private static void deleteTaskNum() {
        System.out.println();
        System.out.print("Введите номер для удаления: ");
        int num = Integer.parseInt(scan.nextLine());
        if (num < 0 || num > tasks.size()) {
            System.out.println("Нет такой задачи.");
        } else {
            tasks.remove(num - 1);
            System.out.println("Удалено!");
        }
    }

    private static void deleteTask() {
        System.out.println();
        System.out.print("Введите задачу для удаления: ");
        String task = scan.nextLine();
        if (tasks.contains(task)) {
            tasks.remove(task);
            System.out.println("Удалено!");
        } else {
            System.out.println("Нет такой задачи.");
            System.out.println();
        }
    }

    private static void deleteByKeyword() {
        System.out.println();
        System.out.print("Введите ключевое слово для удаления: ");
        String keyword = scan.nextLine();
        Iterator<String> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            if (task.toLowerCase().contains(keyword.toLowerCase())) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();

            String choice = scan.nextLine();
            switch (choice) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    addTask();
                    break;
                case "2":
                    break;
                case "3":
                    deleteTaskNum();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    deleteByKeyword();
                    break;
                default:
                    System.out.println("ОШИБКА!");
                    break;
            }
            showTasks();
        }
    }
}

//Выберите операцию:
//
//        0. Выход из программы
//1. Добавить дело
//2. Показать дела
//3. Удалить дело по номеру
//4. Удалить дело по названию