package Assignment17;

public class Activity {
    private int id;
    private String title;
    private String dueDate; // مثال: "2025-10-23T00:00:00"
    private int completed;

    public Activity(Integer o, String learnJava, String dueDate, int completed) {}

    public Activity(int id, String title, String dueDate, int completed) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public int getCompleted() { return completed; }
    public void setCompleted(int completed) { this.completed = completed; }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completed=" + completed +
                '}';
    }
}
