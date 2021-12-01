import java.util.*;

public class Justice {
    private Map<TaskObject, Subject> resultListObj = new HashMap<>();
    private Set<TaskObject> objList;
    private Set<Subject> subList;

    public Justice(Set<TaskObject> objects, Set<Subject> subjects) {
        objList = objects;
        subList = subjects;
    }

}
