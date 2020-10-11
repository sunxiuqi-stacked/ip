//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public Storage() {
    }
    /**
     * write to file
     * ...
     */
    public void writetofile(List<Task> list, int i, String filepath) {
        try {
            File myObj = new File(filepath);
            if (myObj.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(filepath);

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
    public TaskList readFile(String filepath) {
        TaskList taskList = new TaskList();

        try {
            File dataFile = this.checkFileExists(filepath);
            Scanner in = new Scanner(dataFile);
            int i = 0;

            while(in.hasNext()) {
                String line = in.nextLine();
                String[] taskDetails = line.split(" ");
                String type = taskDetails[1];
                line = String.join(" ", Arrays.copyOfRange(taskDetails, 3, taskDetails.length));
                line = line.substring(0,line.length()-1);

                System.out.println("Adding tasks from storage...");

                switch(type) {
                    case "[D]":
                        taskList.addDeadline(line.split("\\(by:"), i);
                        break;
                    case "[E]":
                        taskList.addEvent(line.split("\\(by:)"), i);
                        break;
                    case "[T]":
                        taskList.addTodo(line.split(" "), i);
                        break;
                }

                if (taskDetails[2].equals("[✓]")) {
                    taskList.markDone(i);
                }
                i++;
            }
        } catch (IOException e) {
        }

        return taskList;
    }
}