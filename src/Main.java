import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numObj = 10; // количество объектов
        int numSub = 5; // количество субъектов
        int numOwn = 3; // количество возможных объектов владения для субъекта

        Random random = new Random();
        Justice justice = new Justice();

        // заполняем коллекцию объектами
        for (int i = 0; i < numObj; i++) {
            justice.setListObj(new TaskObject("Ob_"), null); // вводим объект в лист объектов
        }

        // заполняем коллекцию субъектами
        for (int i = 0; i < numSub; i++) {
            Subject subject = new Subject("S_", true); // random.nextBoolean()

            // заполняем коллекцию возможных объектов владения, случайным образом, из созданного ранее листа объектов
            for (int j = 0; j < numOwn; j++) {
                int keyRandom = random.nextInt(justice.getListObj().size());
                TaskObject obj = justice.getListObj().keySet().stream().toList().get(keyRandom);
                subject.setListOwn(obj, false);
            }
            justice.setListSub(subject); // вводим субъекта
        }
        justice.printListObj(justice.getListObj());
        justice.printListSub(justice.getListSub());
        for (int i = 0; i<10; i++) {
            justice.oneSubJust(justice.getListSub().first());
            justice.sortedSub();
            System.out.println("Этап_" + i);
            justice.printListSub(justice.getListSub());
        }
    }




}