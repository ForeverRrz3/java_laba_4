import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Reader> readers = readFromFile("readers.txt");

        Scanner console = new Scanner(System.in);
        System.out.print("Дата сдачи (ГГГГ-ММ-ДД): ");
        LocalDate returned = LocalDate.parse(console.nextLine());

        for (Reader reader : readers) {
            printResult(reader, returned);
        }
    }

    private static ArrayList<Reader> readFromFile(String fileName) throws FileNotFoundException {
        ArrayList<Reader> readers = new ArrayList<Reader>();
        Scanner file = new Scanner(new File(fileName));

        while (file.hasNextLine()) {
            String[] row = file.nextLine().split(";");
            Reader reader = new Reader(row[0]);
            for (int i = 1; i + 2 < row.length; i += 3) {
                reader.addBook(new Book(row[i], row[i + 1], LocalDate.parse(row[i + 2])));
            }
            readers.add(reader);
        }

        file.close();
        return readers;
    }

    private static void printResult(Reader reader, LocalDate returned) {
        for (Book book : reader.getBooks()) {
            System.out.print(reader.getName() + ": " + book + ", сдал " + returned + " ");
            if (book.isReturnOnTime(returned)) {
                System.out.println("вовремя");
            } else {
                System.out.println("с опозданием на " + book.overdueDays(returned) + " дней");
            }
        }
    }
}
