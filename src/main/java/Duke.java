import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        //Generates a greeting
        greeting();
        request();
    }

    public static void request(){
        Scanner in = new Scanner(System.in);
        Task[] list = new Task[100];
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
                for(j=0;j<i;j++){
                    if(list[j].isDone){
                        System.out.println((j+1)+ ". " + "[✓]" + list[j].description);
                    }//not done
                    else {
                        System.out.println((j + 1) + ". " + "[✗] " + list[j].description);
                    }
                }
            }else if(line.contains("done")){
                int num = Integer.parseInt(line.substring(5));
                System.out.println(num);
                list[num-1].isDone = true;
                System.out.println("____________________________________________________________\n"+
                        "Nice! I've marked this task as done:");
                System.out.println("[✓] "+ list[num-1].description + "\n____________________________________________________________\n");
            }else if(line.contains("todo")){
                list[i] = new Todo(line);
                System.out.println("____________________________________________________________\n"+
                        "Got it. I've added this task: ");
                task_count++;
                System.out.println("[T][✗] "+ list[i].description);
                System.out.println("Now you have "+ task_count +" tasks in the list.");
                System.out.println("____________________________________________________________\n");
                i++;
            }else if(line.contains("deadline")){
                String desc[] = line.split("/by");
                list[i] = new Deadline(desc[0],desc[1]);
                System.out.println("____________________________________________________________\n"+
                        "Got it. I've added this task: ");
                task_count++;
                System.out.println("[D][✗] "+ list[i].description + "(by:" + desc[1] +")");
                System.out.println("Now you have "+ task_count +" tasks in the list.");
                System.out.println("____________________________________________________________\n");
                i++;
            }else if(line.contains("event")){
                String desc[] = line.split("/at");
                list[i] = new Deadline(desc[0],desc[1]);
                System.out.println("____________________________________________________________\n"+
                        "Got it. I've added this task: ");
                task_count++;
                System.out.println("[E][✗] "+ list[i].description + "(at:" + desc[1] +")");
                System.out.println("Now you have "+ task_count +" tasks in the list.");
                System.out.println("____________________________________________________________\n");
                i++;
            }else {
                list[i] = new Task(line);
                System.out.println("____________________________________________________________");
                System.out.println("added: "+ line);
                System.out.println("_____________________________________________________________");
                i++;
            }
        }
    }

    public static void greeting(){
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

}

