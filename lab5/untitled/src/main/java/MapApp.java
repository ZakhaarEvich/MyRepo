/**
 * @author Zahar Zakharenko
 * version 1.0
 */
// импорт необходимых классов
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// объявление класса
public class MapApp {
    // объявление главного метода
    public static void main(String args) {
        // создание новой хэш-карты
        Map<String, Integer> map = new HashMap<>();
        // создание нового сканера для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);
        // объявление переменной для команды пользователя
        String command = "";

        // выполнение цикла до тех пор, пока пользователь не введет команду "exit"
        while (!command.equals("exit")) {
            // вывод приглашения для ввода команды
            System.out.println("Enter the command (add, remove, show, exit):");
            // чтение ввода пользователя
            command = scanner.nextLine();

            // выполнение действия в зависимости от введенной команды
            switch (command) {
                case "add":
                    // запрос ключа и значения для добавления объекта в хэш-карту
                    System.out.println("Enter the key:");
                    String key = scanner.nextLine();
                    System.out.println("Enter a value:");
                    int value = Integer.parseInt(scanner.nextLine());
                    // добавление объекта в хэш-карту
                    map.put(key, value);
                    System.out.println("The object was added successfully.");
                    break;
                case "remove":
                    // запрос ключа для удаления объекта из хэш-карты
                    System.out.println("Enter the key:");
                    key = scanner.nextLine();
                    // проверка наличия объекта с данным ключом в хэш-карте
                    if (map.containsKey(key)) {
                        // удаление объекта из хэш-карты
                        map.remove(key);
                        System.out.println("The object was successfully deleted.");
                    } else {
                        System.out.println("An object with such a key was not found.");
                    }
                    break;
                case "show":
                    // вывод текущего списка объектов в хэш-карте
                    System.out.println("Current list of objects:");
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                    break;
                case "exit":
                    // вывод сообщения об окончании программы
                    System.out.println("The program is completed.");
                    break;
                default:
                    // вывод сообщения о неверной команде
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}