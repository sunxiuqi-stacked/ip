public class Task {
    protected String description;
    protected boolean isDone;
    protected int listCount;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.listCount = 0;
    }

    public int length() {
        return listCount; //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }

}