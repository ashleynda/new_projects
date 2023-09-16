package Data.models;


import java.time.LocalDateTime;

public class Entry{
    private int id;
    private String title;
    private String body;

    private String ownerName;
    private LocalDateTime timeCreated = LocalDateTime.now();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
    @Override
    public String toString() {
        return "entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", timeCreated=" + timeCreated +
                '}';
    }




}
