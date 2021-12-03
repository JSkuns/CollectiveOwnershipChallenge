import java.util.*;

public class TaskObject {
    private String name; // Название объекта
    private int id; // уникальный id объекта
    private static int idGenerator = 1;
    private Subject owner; // владелец объекта
    public TaskObject(String name) {
        id = idGenerator++;
        this.name = name + id;
    }

    public Subject getOwner() {
        return owner;
    }

    public void setOwner(Subject owner) {
        this.owner = owner;
    }

    public boolean freeObj() {
        return getOwner() == null;
    }

    public void delOwner() {
        owner = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskObject that = (TaskObject) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return name;
    }
}
