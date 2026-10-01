import java.time.LocalDate;

public class Book {
    private String title, author;
    private LocalDate dateReturn;

    public Book(String title, String author, LocalDate dateReturn){
        this.title = title;
        this.author = author;
        this.dateReturn = dateReturn;
    }

    public Book(){
        title = "Без названия";
        author = "Неизвестный";
        dateReturn = LocalDate.now();
    }

    public Book(Book other){
        title = other.title;
        author = other.author;
        dateReturn = other.dateReturn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle(){
        return title;
    }

    public LocalDate getDateReturn(){
        return dateReturn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    public boolean isReturnOnTime(LocalDate date){
        return !date.isAfter(dateReturn);
    }

    public long overdueDays(LocalDate date){
        long days = date.toEpochDay() - dateReturn.toEpochDay();
        return Math.max(days, 0);
    }

    @Override
    public String toString() {
        return author + " \"" + title + "\", сдать до: " + dateReturn;
    }
}
