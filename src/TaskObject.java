import java.util.*;

public class TaskObject {
    private String name; // Название объекта
    private int id; // уникальный id объекта
    private static int idGenerator = 1;
    private Subject owner; // владелец объекта
    public TaskObject(String name) {
        this.name = name;
        id = idGenerator++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getOwner() {
        return owner;
    }

    public void setOwner(Subject owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskObject that = (TaskObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + id + (owner == null ? "" : " >>> " + owner);
    }
}
