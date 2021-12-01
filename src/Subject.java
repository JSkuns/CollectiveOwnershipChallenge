import java.util.Map;

public class Subject {
    private String name;
    private int id; // уникальный id субъекта
    private static int idGenerator = 1;
    private Map<TaskObject, Boolean> canOwn; // Список объектов чем может владеть субъект
    private boolean priority; // Приоритет нв владение объектами

    public Subject(String name, Map<TaskObject, Boolean> canOwn, boolean priority) {
        this.name = name;
        this.canOwn = canOwn;
        this.priority = priority;
        id = idGenerator++;
    }

    @Override
    public String toString() {
        return name + id +"(" + (!priority ? "0" : "1") + ")" + " canOwn=" + canOwn.entrySet() ;
    }
}
