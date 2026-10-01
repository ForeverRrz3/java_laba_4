import java.util.ArrayList;

public class Reader {
    private String name;
    private ArrayList<Book> books;

    public Reader() {
        name = "Неизвестный";
        books = new ArrayList<Book>();
    }

    public Reader(String name) {
        this.name = name;
        books = new ArrayList<Book>();
    }

    public Reader(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = new ArrayList<Book>(books);
    }

    public Reader(Reader other) {
        name = other.name;
        books = new ArrayList<Book>();
        for (Book b : other.books) {
            books.add(new Book(b));
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = new ArrayList<Book>(books);
    }
}
