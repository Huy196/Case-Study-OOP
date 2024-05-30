import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedMap;

public class Library {
    final int Maximal = 1000;

    private eBooks[] eBooks = new eBooks[Maximal];

    private int conut = 0;

    public void getPrintBook() {
        for (int i = 0; i < conut; i++) {
            System.out.println(eBooks[i]);
        }
    }

    public boolean updateBook(String maSach, String tieuDeSach, String tacGia, int namXuatBan, String theLoai, double kichThuocTep, String dinhDangTep) {
        for (int i = 0; i < this.conut; i++) {
            if (eBooks[i] != null && eBooks[i].getMaSach().equalsIgnoreCase(maSach)) {
                eBooks[i].setMaSach(maSach);
                eBooks[i].setTieuDeSach(tieuDeSach);
                eBooks[i].setTacGia(tacGia);
                eBooks[i].setNamXuatBan(namXuatBan);
                eBooks[i].setTheLoai(theLoai);
                eBooks[i].setKichThuocTep(kichThuocTep);
                eBooks[i].setDinhDangTep(dinhDangTep);
                return true;
            }
        }
        return false;
    }

    public boolean addBook(eBooks eBooks) {
        if (this.conut >= Maximal)
            return false;
        for (int i = 0; i < conut; i++) {
            if (this.eBooks[i].getMaSach().equalsIgnoreCase(eBooks.getMaSach())) {
                return false;
            }
        }
        this.eBooks[conut++] = eBooks;
        return true;
    }

    public boolean remoteBook(String book) {
        if (this.conut <= 0) {
            return false;
        } else {
            for (int i = 0; i < eBooks.length; i++) {
                if (eBooks[i] != null && eBooks[i].getMaSach().equalsIgnoreCase(book)) {
                    for (int j = i; j < this.conut - 1; j++) {
                        eBooks[j] = eBooks[j + 1];
                    }
                    this.conut--;
                    return true;
                }
            }
            return false;
        }
    }

    public void sortByBookTitle(boolean ascending) {


        Comparator<Book> comparator = Comparator.comparing(Book::getTieuDeSach);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Arrays.sort(eBooks, 0, conut, comparator);

    }

    public void sortByAuthor(boolean ascending) {
        Comparator<Book> comparator = Comparator.comparing(Book::getTacGia);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Arrays.sort(eBooks, 0, conut, comparator);
    }

    public void sortByYearOfPublication(boolean ascending) {
        Comparator<Book> comparator = Comparator.comparing(Book::getNamXuatBan);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        Arrays.sort(eBooks, 0, conut, comparator);
    }

    public eBooks searchForBooksByBookCode(String keyword) {
        for (int i = 0; i < this.conut; i++) {
            if (this.eBooks[i].getMaSach().equalsIgnoreCase(keyword)) {
                return eBooks[i];
            }
        }
        return null;
    }

    public eBooks searchForBooksByTitle(String keyword) {
        for (int i = 0; i < this.conut; i++) {
            if (this.eBooks[i].getTieuDeSach().equalsIgnoreCase(keyword)) {
                return eBooks[i];
            }
        }
        return null;
    }

    public void menuEbooks() {
        System.out.println("\nMenu:");
        System.out.println("1. See library list.");
        System.out.println("2. Add book.");
        System.out.println("3. Update book.");
        System.out.println("4. Remote book.");
        System.out.println("5. Sort by book title.");
        System.out.println("6. Sort by author.");
        System.out.println("7. Sort by year of publication.");
        System.out.println("8. Find books by code.");
        System.out.println("9. Find books by title.");
        System.out.println("0. Exit.");
        System.out.println("Enter your selection : ");
        System.out.println("----------------------------------------------");
    }

    public void dataTransmittedAdd() {

        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);

        System.out.println("Please enter the book code:");
        String maSach = input1.nextLine();
        System.out.println("Please fill in the book title : ");
        String tieuDe = input1.nextLine();
        System.out.println("Author : ");
        String tacGia = input1.nextLine();
        System.out.println("Male export:");
        int namXuatBan = input.nextInt();
        System.out.println("The type:");
        String theLoai = input1.nextLine();
        System.out.println("File Size :");
        double kichThuoc = input.nextDouble();
        System.out.println("File format:");
        String dinhDangTep = input1.nextLine();
        System.out.println("----------------------");

        boolean h = this.addBook(new eBooks(maSach, tieuDe, tacGia, namXuatBan, theLoai, kichThuoc, dinhDangTep));
        if (h) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("The book code already exists and cannot be added!");
        }
    }

    public void dataTransmittedUpdate() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);

        System.out.println("Please enter the book code:");
        String maSach = input1.nextLine();
        System.out.println("Please fill in the book title :");
        String tieuDe = input1.nextLine();
        System.out.println("Author : ");
        String tacGia = input1.nextLine();
        System.out.println("Male export:");
        int namXuatBan = input.nextInt();
        System.out.println("The type:");
        String theLoai = input1.nextLine();
        System.out.println("File Size :");
        double kichThuoc = input.nextDouble();
        System.out.println("File format:");
        String dinhDangTep = input1.nextLine();
        System.out.println("----------------------");

        boolean Update = this.updateBook(maSach, tieuDe, tacGia, namXuatBan, theLoai, kichThuoc, dinhDangTep);

        if (Update) {
            System.out.println("Update successful!");
        } else {
            System.out.println("Book code not found!");
        }
    }
    public void DeteleBookByCode(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the book code : ");
        String Code = input.nextLine();
        boolean remoteBook = this.remoteBook(Code);
        if (remoteBook) {
            System.out.println("Removed from library!");
        } else {
            System.out.println("There are no books in the library!");
        }
    }

    public void SearchByBookCode() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter the book code:");
        String maSach2 = input1.nextLine();
        if (this.searchForBooksByBookCode(maSach2) == null) {
            System.out.println("Book code does not exist!");
        } else {
            System.out.println(this.searchForBooksByBookCode(maSach2));
        }
    }

    public void SearchByBookTitle() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please fill in the book title : ");
        String tieuDeSach2 = input1.nextLine();

        if (this.searchForBooksByTitle(tieuDeSach2) == null) {
            System.out.println("Title does not exist!");
        } else {
            System.out.println(this.searchForBooksByTitle(tieuDeSach2));
        }
    }
}



