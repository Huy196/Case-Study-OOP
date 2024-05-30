import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.addBook(new eBooks("001", "Toán Học", "Tùy ý", 2021, "Nghiên cứu", 100.0, ".docx"));
        library.addBook(new eBooks("002", "Văn Học", "Nụ Cười Xuân", 2024, "Ngôn tình", 100.0, "docx"));

        Scanner input = new Scanner(System.in);

        while (true) {
            library.menuEbooks();
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("List of books : ");
                    library.getPrintBook();
                    break;
                case 2:
                    library.dataTransmittedAdd();
                    break;
                case 3:
                    library.dataTransmittedUpdate();
                    break;
                case 4:
                    library.DeteleBookByCode();
                    break;
                case 5:
                    System.out.println("Sort by title : ");
                    library.sortByBookTitle(false);
                    library.getPrintBook();
                    break;
                case 6:
                    System.out.println("Sort by author:");
                    library.sortByAuthor(false);
                    library.getPrintBook();
                    break;
                case 7:
                    System.out.println("Sort by year of publication.");
                    library.sortByYearOfPublication(true);
                    library.getPrintBook();
                    break;
                case 8:
                    library.SearchByBookCode();
                    break;
                case 9:
                    library.SearchByBookTitle();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
}