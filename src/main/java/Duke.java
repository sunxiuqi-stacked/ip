//import java.util.Scanner;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import java.util.Scanner;

public class Duke {
    public static String PATH = "C:\\Users\\HELIOS\\Downloads\\STUDY MATERIALS\\AY2021_SEM1\\CS2113\\Individualproject\\ip\\data\\duke.txt";
    private static Storage storage = new Storage();
    private static TaskList tasks = new TaskList();
    private static Ui ui = new Ui();
    private static Parser parser = new Parser();

    public Duke() {
    }

    public static void main(String[] args) {
        Ui.greeting();
        tasks = new TaskList(storage.readFile());
        TaskList.task_count = 0;
        request();
    }

    public static void request() {
        Scanner in = new Scanner(System.in);
        int i = 0;

        while(true) {
            String status = "[✗] ";
            String line = in.nextLine();
            if (line.equals("bye")) {
                ui.bye();
                return;
            }

            if (line.equals("list")) {
                System.out.println(" ____________________________________________________________\nHere are the tasks in your list: ");
                tasks.printList(i);
            } else if (line.contains("done")) {
                int num = Integer.parseInt(line.substring(5));
                System.out.println(num);
                tasks.markDone(num);
            } else {
                String[] desc;
                if (parser.Contains(line, "todo")) {
                    try {
                        desc = line.split(" ");
                        tasks.addTodo(desc, i);
                        ++i;
                    } catch (ArrayIndexOutOfBoundsException var10) {
                        ui.oops("todo");
                    }
                } else if (parser.Contains(line, "deadline")) {
                    try {
                        desc = line.split("/by");
                        tasks.addDeadline(desc, i);
                        ++i;
                    } catch (ArrayIndexOutOfBoundsException var9) {
                        ui.oops("deadline");
                    }
                } else if (parser.Contains(line, "event")) {
                    try {
                        desc = line.split("/at");
                        tasks.addEvent(desc, i);
                        ++i;
                    } catch (ArrayIndexOutOfBoundsException var8) {
                        ui.oops("event");
                    }
                } else if (parser.Contains(line, "task")) {
                    tasks.addTask(line, i);
                    ++i;
                } else if (parser.Contains(line, "delete")) {
                    try {
                        desc = line.split(" ");
                        i = Integer.parseInt(desc[1]) - 1;
                        tasks.delete(i);
                        ++i;
                    } catch (ArrayIndexOutOfBoundsException var7) {
                        ui.oops("task");
                    }
                } else if (parser.Contains(line, "save")) {
                    storage.writetofile(tasks.returnList(), i);
                } else if (parser.Contains(line, "find")) {
                    try {
                        desc = line.split(" ");
                        String description = desc[1];
                        tasks.Find(description);
                    } catch (ArrayIndexOutOfBoundsException var6) {
                        ui.oops("find");
                    }
                } else {
                    ui.dunno();
                }
            }
        }
    }
}


