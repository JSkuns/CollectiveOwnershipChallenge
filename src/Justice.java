import java.util.*;

public class Justice {
    Comparator<Subject> comparatorId = Comparator.comparing(Subject::getId);
    Comparator<Subject> comparatorIdRev = Comparator.comparing(Subject::getId, Comparator.reverseOrder());
    Comparator<Subject> comparatorPriority = Comparator.comparing(Subject::isPriority).thenComparing(Subject::getId);
    Comparator<Subject> comparatorPriorityRev = Comparator.comparing(Subject::isPriority, Comparator.reverseOrder()).thenComparing(Subject::numOfOwnSub, Comparator.reverseOrder()).thenComparing(Subject::getId);
    Comparator<Subject> comparatorOwn = Comparator.comparing(Subject::numOfOwnSub).thenComparing(Subject::getId);
    Comparator<Subject> comparatorOwnRev = Comparator.comparing(Subject::numOfOwnSub, Comparator.reverseOrder()).thenComparing(Subject::getId);

    private Map<TaskObject, Subject> listObj = new HashMap<>();
    private TreeSet<Subject> listSub = new TreeSet<>(comparatorPriorityRev);

    public void setListObj(TaskObject taskObject, Subject subject) {
        listObj.put(taskObject, subject);
    }

    public void setListSub(Subject subject) {
        listSub.add(subject);
    }

    public Map<TaskObject, Subject> getListObj() {
        return listObj;
    }

    public TreeSet<Subject> getListSub() {
        return listSub;
    }

    public int numOfOwnObj() { // колличество свободных объектов
        int result = 0;
        for (Map.Entry<TaskObject, Subject> map : listObj.entrySet()) {
            if (map.getValue() == null) {
                result++;
            }
        }
        return result;
    }

    public boolean analisis(Map.Entry<TaskObject, Boolean> map) {
       if (!map.getValue() && listObj.get(map.getKey()) == null) {
           return true;
       }
        return false;
    }

    public void sortedSub() {
        TreeSet<Subject> temp = new TreeSet<>(comparatorPriorityRev);
        for (Subject subject : listSub) {
            System.out.println(subject);
            temp.add(subject);
        }
        listSub.clear();
        listSub.addAll(temp);
    }

    public void oneSubJust(Subject subject) {
        for (Map.Entry<TaskObject, Boolean> map : subject.getListOwn().entrySet()) {
            if (analisis(map))  {
                listObj.put(map.getKey(), subject);
                map.setValue(true);
            }
        }
    }

    public void printListSub(TreeSet<Subject> subjects) {
        System.out.println("\nЛист всех субъектов:");
        for (Subject subject : subjects) {
            int i = 0;
            System.out.printf("%5s  (%s)  [%s]  [", subject.getName(), (!subject.isPriority() ? "0" : "1"), subject.numOfOwnSub());
            for (Map.Entry<TaskObject, Boolean> map : subject.getListOwn().entrySet()) {
                System.out.print(map.getKey() + (!map.getValue() ? "(-)" : "(+)"));
                i++;
                if (i < subject.getListOwn().size()) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public void printListObj(Map<TaskObject, Subject> listObj) {
        System.out.println("\nЛист всех объектов:");
        for (Map.Entry<TaskObject, Subject> map : listObj.entrySet()) {
            System.out.printf("%5s  %5s\n", map.getKey(), map.getValue());
        }
    }

}
