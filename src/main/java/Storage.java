//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public Storage() {
    }
    /**
     * write to file
     * ...
     */
    public void writetofile(List<Task> list, int i) {
        try {
            File myObj = new File("..\\..\\..\\..\\ip\\data\\duke.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException var7) {
            System.out.println("An error occurred.");
            var7.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("..\\..\\..\\..\\ip\\data\\duke.txt");

            for(int j = 0; j < i; ++j) {
                String timing = "";
                Object var10000;
                String classtype;
                if (list.get(j) instanceof Deadline) {
                    classtype = "[D]";
                    var10000 = list.get(j);
                    timing = "(by: " + ((Deadline)var10000).getBy() + ")";
                } else if (list.get(j) instanceof Todo) {
                    classtype = "[T]";
                } else if (list.get(j) instanceof Event) {
                    classtype = "[E]";
                    var10000 = list.get(j);
                    timing = "(at: " + ((Event)var10000).getWhen() + ")";
                } else {
                    classtype = "task";
                }

                if (((Task)list.get(j)).isDone) {
                    myWriter.write(j + 1 + ". " + classtype + " [✓] " + ((Task)list.get(j)).description + " " + timing + "\n");
                } else {
                    myWriter.write(j + 1 + ". " + classtype + " [X] " + ((Task)list.get(j)).description + " " + timing + "\n");
                }
            }

            myWriter.close();
            System.out.println("Successfully saved to the file.");
        } catch (IOException var8) {
            System.out.println("An error occurred.");
            var8.printStackTrace();
        }

    }

    public File checkFileExists(String filePath) throws IOException {
        File dataFile = new File(filePath);
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }

        return dataFile;
    }
    /**
     * generate list from file
     * ...
     */
    public List<Task> readFile() {
        ArrayList taskList = new ArrayList();

        try {
            File dataFile = this.checkFileExists("..\\..\\..\\..\\ip\\data\\duke.txt");
            Scanner in = new Scanner(dataFile);

            while(in.hasNext()) {
                String line = in.nextLine();
                String[] taskDetails = line.split(" ");
                String var6 = taskDetails[1];
                byte var7 = -1;
                switch(var6.hashCode()) {
                    case 89652:
                        if (var6.equals("[D]")) {
                            var7 = 1;
                        }
                        break;
                    case 89683:
                        if (var6.equals("[E]")) {
                            var7 = 2;
                        }
                        break;
                    case 90148:
                        if (var6.equals("[T]")) {
                            var7 = 0;
                        }
                }

                switch(var7) {
                    case 0:
                        taskList.add(new Todo(taskDetails[3]));
                        break;
                    case 1:
                        taskList.add(new Deadline(taskDetails[3], taskDetails[4]));
                        break;
                    case 2:
                        taskList.add(new Event(taskDetails[3], taskDetails[4]));
                        break;
                    default:
                        taskList.add(new Task(taskDetails[3]));
                }

                if (taskDetails[2].equals("[✓]")) {
                    int taskIndex = taskList.size() - 1;
                    ((Task)taskList.get(taskIndex)).markAsDone();
                }
            }
        } catch (IOException e) {
        }

        return taskList;
    }
}