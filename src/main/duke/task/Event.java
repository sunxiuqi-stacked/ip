package main.duke.task;
public class Event extends Task {
    protected String when;
    public Event(String description, String when) {
        super(description);
        this.when = when;
    }

    public String getWhen(){
        return when;
    }
    public void setWhen(String when){
        this.when = when;
    }
}
