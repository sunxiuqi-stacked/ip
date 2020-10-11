//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.*;

public class TaskList {
    public static List<Task> list;
    public static int task_count;

    //tasks init
    public TaskList() {
        list = new ArrayList();
        task_count = 0;
    }

    public TaskList(List<Task> list) {
        TaskList.list = list;
        task_count = list.size();
    }

    /**
     * print list values based on integer i
     * ...
     */
    public void printList(int i) {
        for(int j = 0; j < i; ++j) {
            String timing = "";
            String classtype;
            if (list.get(j) instanceof Deadline) {
                classtype = "[D]";
                timing = "(by: " + ((Deadline)list.get(j)).getBy() + ")";
            } else if (list.get(j) instanceof Todo) {
                classtype = "[T]";
            } else if (list.get(j) instanceof Event) {
                classtype = "[E]";
                timing = "(at: " + ((Event)list.get(j)).getWhen() + ")";
            } else {
                classtype = "[T]";
            }

            if (((Task)list.get(j)).isDone) {
                System.out.println(j + 1 + ". " + classtype + "[✓]" + ((Task)list.get(j)).description + timing);
            } else {
                System.out.println(j + 1 + ". " + classtype + "[✗] " + ((Task)list.get(j)).description + timing);
            }
        }

    }

    /**
     * print list values based on list
     * ...
     */
    public static void printList(List<Task> list) {
        for(int j=0;j<list.size();j++){
            String classtype;
            String timing = "";
            if(list.get(j) instanceof Deadline){
                classtype = "[D]";
                timing = "(by: "+((Deadline) list.get(j)).getBy()+")";
            }
            else if(list.get(j) instanceof Todo){
                classtype = "[T]";
            }
            else if(list.get(j) instanceof Event){
                classtype = "[E]";
                timing = "(at: "+((Event) list.get(j)).getWhen()+")";
            }
            else{
                classtype = "[T]";
            }
            if(list.get(j).isDone){
                System.out.println((j+1)+ ". "+ classtype + "[✓]" + list.get(j).description + timing);
            }//not done
            else {
                System.out.println((j + 1) + ". " +classtype+ "[✗] " + list.get(j).description + timing);
            }
        }

    }

    /**
     * mark as done
     * ...
     */
    public void markDone(int num) {
        ((Task)list.get(num - 1)).isDone = true;
        System.out.println("____________________________________________________________\nNice! I've marked this task as done:");
        System.out.println("[✓] " + ((Task)list.get(num - 1)).description + "\n____________________________________________________________\n");
    }

    /**
     * add task types to list
     * ...
     */
    public static void addTodo(String[] desc, int i) {
        list.add(i, new Todo(desc[1]));
        System.out.println("____________________________________________________________\nGot it. I've added this task: ");
        task_count++;
        System.out.println("[T][✗] " + ((Task)list.get(i)).description);
        System.out.println("Now you have " + task_count + " tasks in the list.");
        System.out.println("____________________________________________________________\n");
    }

    public static void addDeadline(String[] desc, int i) {
        list.add(i, new Deadline(desc[0], desc[1]));
        System.out.println("____________________________________________________________\nGot it. I've added this task: ");
        task_count++;
        System.out.println("[D][✗] " + ((Task)list.get(i)).description + "(by:" + desc[1] + ")");
        System.out.println("Now you have " + task_count + " tasks in the list.");
        System.out.println("____________________________________________________________\n");
    }

    public static void addEvent(String[] desc, int i) {
        list.add(i, new Event(desc[0], desc[1]));
        System.out.println("____________________________________________________________\nGot it. I've added this task: ");
        task_count++;
        System.out.println("[E][✗] " + ((Task)list.get(i)).description + "(at:" + desc[1] + ")");
        System.out.println("Now you have " + task_count + " tasks in the list.");
        System.out.println("____________________________________________________________\n");
    }

    public void addTask(String line, int i) {
        list.add(i, new Task(line));
        System.out.println("____________________________________________________________");
        System.out.println("added: " + line);
        System.out.println("_____________________________________________________________");
    }

    /**
     * delete task
     * ...
     */
    public void delete(int i) {
        String timing = "";
        String classtype;
        if (list.get(i) instanceof Deadline) {
            classtype = "[D]";
            timing = "(by: " + ((Deadline)list.get(i)).getBy() + ")";
        } else if (list.get(i) instanceof Todo) {
            classtype = "[T]";
        } else if (list.get(i) instanceof Event) {
            classtype = "[E]";
            timing = "(at: " + ((Event)list.get(i)).getWhen() + ")";
        } else {
            classtype = "[T]";
        }

        System.out.println("____________________________________________________________\nNoted. I've removed this task: ");
        if (((Task)list.get(i)).isDone) {
            System.out.println(i + 1 + ". " + classtype + "[✓]" + ((Task)list.get(i)).description + timing);
        } else {
            System.out.println(i + 1 + ". " + classtype + "[✗] " + ((Task)list.get(i)).description + timing);
        }

        --task_count;
        list.remove(list.get(i));
        System.out.println("Now you have " + task_count + " tasks in the list.");
        System.out.println("____________________________________________________________\n");
    }

    public List<Task> returnList() {
        return list;
    }

    /**
     * find matching tasks in list
     *
     */
    public static void Find(String description) {
        List<Task> returnList = new ArrayList();
        System.out.println(" Here are the matching tasks in your list: ");

        for(int i = 0; i < list.size(); ++i) {
            Task task = (Task)list.get(i);
            if (task.description.contains(description)) {
                returnList.add(i, (Task)list.get(i));
            }
        }

        printList(returnList);
    }
}