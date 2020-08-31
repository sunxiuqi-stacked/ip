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

        while(true) {
            String status ="[✗] ";
            line = in.nextLine();

            if (line.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }else if(line.equals("list")){
                for(j=0;j<i;j++){
                    if(list[j].isDone){
                        System.out.println((j+1)+ ". " + "[✓]" + list[j].description);
                    }//not done
                    System.out.println((j+1)+ ". " + "[✗] " + list[j].description);
                }
            }else if(line.contains("done")){
                int num = Integer.parseInt(line.substring(5));
                System.out.println(num);
                list[num-1].isDone = true;
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[✓] "+ list[num-1].description);
            } else {
                list[i] = new Task(line);
                System.out.println("added: "+ line);
                i++;
            }
        }
    }

    public static void greeting(){
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

}