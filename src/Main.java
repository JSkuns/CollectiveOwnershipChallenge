import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numObj = 20; // количество объектов
        int numSub = 5; // количество субъектов
        int numOwn = 3; // количество возможных объектов владения для субъекта

        Random random = new Random(); // нужен для случайного выбора возможных объектов владения

        Set<TaskObject> listObj = new HashSet<>(); // коллекция всех уникальных объектов
        Set<Subject> listSub = new HashSet<>(); // коллекция всех уникальных субъектов

        // заполняем коллекцию объектами
        for (int i = 0; i < numObj; i++) {
            listObj.add(new TaskObject("Ob_")); // вводим имя объекта
        }

        // заполняем коллекцию субъектами
        for (int i = 0; i < numSub; i++) {
            Map<TaskObject, Boolean> tempList = new HashMap<>(); // коллекция возможных объектов владения

            // заполняем коллекцию возможных объектов владения, случайным образом, из созданного ранее листа объектов
            for (int j = 0; j < numOwn; j++) {
                tempList.put((TaskObject) listObj.toArray()[random.nextInt(listObj.size())], false);
            }

            listSub.add(new Subject("Sb_", tempList, true)); // вводим имя субъекта и его приоритет
        }

        Justice justice = new Justice(listObj,listSub);

        printListObj(listObj);
        printListSub(listSub);
    }

    public static void printListObj(Set<TaskObject> list) {
        Iterator<TaskObject> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void printListSub(Set<Subject> subjects) {
        Iterator<Subject> iter = subjects.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}