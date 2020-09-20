//import java.util.Scanner;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Duke {
    public static void main(String[] args) {
        //Generates a greeting
        greeting();
        request();
    }

    public static void request(){
        Scanner in = new Scanner(System.in);
        List<Task> list = new ArrayList<Task>();
        String line;
        int i=0,j;
        int task_count = 0;
        while(true) {
            String status ="[✗] ";
            line = in.nextLine();

            if (line.equals("bye")){
                System.out.println("____________________________________________________________\n"
                        +"Bye. Hope to see you again soon!\n"
                +"____________________________________________________________\n");
                break;
            }else if(line.equals("list")){
                System.out.println(" ____________________________________________________________\n"
                        + "Here are the tasks in your list: ");
                for(j=0;j<i;j++){
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
            }else if(line.contains("done")){
                int num = Integer.parseInt(line.substring(5));
                System.out.println(num);
                list.get(num-1).isDone = true;
                System.out.println("____________________________________________________________\n"+
                        "Nice! I've marked this task as done:");
                System.out.println("[✓] "+ list.get(num-1).description + "\n____________________________________________________________\n");
            }else if(line.contains("todo")) {
                try{
                    String desc[] = line.split(" ");
                    list.add(i, new Todo(desc[0]));
                    System.out.println("____________________________________________________________\n" +
                        "Got it. I've added this task: ");
                    task_count++;
                    System.out.println("[T][✗] " + list.get(i).description);
                    System.out.println("Now you have " + task_count + " tasks in the list.");
                    System.out.println("____________________________________________________________\n");
                i++;
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("____________________________________________________________\n" +
                            "0x00002639 OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }

            }else if(line.contains("deadline")){
                try {
                    String desc[] = line.split("/by");
                    list.add(i, new Deadline(desc[0], desc[1]));
                    System.out.println("____________________________________________________________\n" +
                            "Got it. I've added this task: ");
                    task_count++;
                    System.out.println("[D][✗] " + list.get(i).description + "(by:" + desc[1] + ")");
                    System.out.println("Now you have " + task_count + " tasks in the list.");
                    System.out.println("____________________________________________________________\n");
                    i++;
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("____________________________________________________________\n" +
                            "☹ OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
            }else if(line.contains("event")){
                try {
                    String desc[] = line.split("/at");
                    list.add(i, new Event(desc[0], desc[1]));

                    System.out.println("____________________________________________________________\n" +
                            "Got it. I've added this task: ");
                    task_count++;
                    System.out.println("[E][✗] " + list.get(i).description + "(at:" + desc[1] + ")");
                    System.out.println("Now you have " + task_count + " tasks in the list.");
                    System.out.println("____________________________________________________________\n");
                    i++;
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("____________________________________________________________\n" +
                            "☹ OOPS!!! The description of an event cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
            }else if(line.contains("task")){
                list.add(i, new Task(line));
                System.out.println("____________________________________________________________");
                System.out.println("added: "+ line);
                System.out.println("_____________________________________________________________");
                i++;
            }else if(line.contains("delete")) {
                try {
                    String desc[] = line.split(" ");
                    i = Integer.parseInt(desc[1])-1;
                    String classtype;
                    String timing = "";
                    if(list.get(i) instanceof Deadline){
                        classtype = "[D]";
                        timing = "(by: "+((Deadline) list.get(i)).getBy()+")";
                    }
                    else if(list.get(i) instanceof Todo){
                        classtype = "[T]";
                    }
                    else if(list.get(i) instanceof Event){
                        classtype = "[E]";
                        timing = "(at: "+((Event) list.get(i)).getWhen()+")";
                    }
                    else{
                        classtype = "[T]";
                    }
                    System.out.println("____________________________________________________________\n" +
                            "Noted. I've removed this task: ");
                    if(list.get(i).isDone){
                        System.out.println((i+1)+ ". "+ classtype + "[✓]" + list.get(i).description + timing);
                    }//not done
                    else {
                        System.out.println((i + 1) + ". " +classtype+ "[✗] " + list.get(i).description + timing);
                    }
                    task_count--;
                    System.out.println("Now you have " + task_count + " tasks in the list.");
                    System.out.println("____________________________________________________________\n");
                    i++;
                }catch(ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________\n" +
                            "☹ OOPS!!! The description of a delete cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
            }else if(line.contains("save")) {
               writetofile(list,i);
            }
            else{
                System.out.println("____________________________________________________________");
                System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-( ");
                System.out.println("_____________________________________________________________");
            }
        }
    }

    public static void greeting(){
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }
    public static void writetofile(List<Task> list, int i){
        try {
            File myObj = new File("C:\\Users\\HELIOS\\Downloads\\STUDY MATERIALS\\AY2021_SEM1\\CS2113\\Individualproject\\ip\\data\\duke.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\HELIOS\\Downloads\\STUDY MATERIALS\\AY2021_SEM1\\CS2113\\Individualproject\\ip\\data\\duke.txt");
            for(int j=0;j<i;j++){
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
                    myWriter.write((j+1)+ ". "+ classtype + "[✓]" + list.get(j).description + timing + "\n");
                }//not done
                else {
                    myWriter.write((j + 1) + ". " +classtype+ "[✗] " + list.get(j).description + timing + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully saved to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

