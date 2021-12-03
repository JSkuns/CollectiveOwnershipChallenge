import java.util.*;

public class Subject {
    private String name;
    private int id; // уникальный id субъекта
    private static int idGenerator = 1;
    private Map<TaskObject, Boolean> listOwn = new HashMap<>(); // Список объектов чем может владеть субъект
    private boolean priority; // Приоритет на владение объектами

    public Subject(String name, boolean priority) {
        id = idGenerator++;
        this.name = name + id;
        this.priority = priority;
    }

    public void setListOwn(TaskObject taskObject, Boolean value) {
        listOwn.put(taskObject, value);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isPriority() {
        return priority;
    }

    public Map<TaskObject, Boolean> getListOwn() {
        return listOwn;
    }

    public boolean addCanOwn(TaskObject object) {
        return listOwn.put(object, false);
    }

    public boolean delCanOwn(TaskObject object) {
        return listOwn.remove(object);
    }

    public int numOfOwnSub() { // колличество имеющихся владений субъекта
        int result = 0;
        for (Map.Entry<TaskObject, Boolean> entry : listOwn.entrySet()) {
            if (entry.getValue()) {
                result++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(String.format("%5s  (%s)  <%s>  [", name, (!priority ? "0" : "1"), numOfOwnSub()));
        for (Map.Entry<TaskObject, Boolean> map : listOwn.entrySet()) {
            sb.append(map.getKey()).append(!map.getValue() ? "(-)" : "(+)");
            i++;
            if (i < listOwn.entrySet().size()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
