import java.util.ArrayList;
import java.util.List;

public class BookstoreManager {
    private List<Book> inventory;

    public BookstoreManager() {
        this.inventory = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // Physical Printed Books (Weight in Kg)
        addBook(new PrintedBook("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 28.50, 1.20));
        addBook(new PrintedBook("Steve Jobs", "Walter Isaacson", 32.00, 1.45));
        addBook(new PrintedBook("Dune", "Frank Herbert", 22.00, 0.95));
        addBook(new PrintedBook("To Kill a Mockingbird", "Harper Lee", 18.99, 0.60));
        addBook(new PrintedBook("Thinking, Fast and Slow", "Daniel Kahneman", 24.99, 0.85));
        addBook(new PrintedBook("Clean Code", "Robert C. Martin", 45.99, 0.88));
        addBook(new PrintedBook("Educated", "Tara Westover", 19.99, 0.70));
        addBook(new PrintedBook("Design Patterns", "Erich Gamma", 54.50, 1.10));

        // Digital E-Books (File Size in MB)
        addBook(new EBook("Atomic Habits", "James Clear", 27.00, 4.2));
        addBook(new EBook("1984", "George Orwell", 15.50, 2.8));
        addBook(new EBook("The Psychology of Money", "Morgan Housel", 20.50, 3.5));
        addBook(new EBook("Shoe Dog", "Phil Knight", 21.40, 5.1));
        addBook(new EBook("The Great Gatsby", "F. Scott Fitzgerald", 12.75, 1.9));
        addBook(new EBook("Astrophysics for People in a Hurry", "Neil deGrasse Tyson", 16.80, 2.4));
        addBook(new EBook("Head First Java", "Kathy Sierra", 42.80, 14.6));
    }

    public void addBook(Book book) {
        if (book != null) {
            inventory.add(book);
        }
    }

    public Book getBookByIndex(int index) {
        if (index >= 0 && index < inventory.size()) {
            return inventory.get(index);
        }
        return null;
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public void displayInventory() {
        System.out
                .println("\n-----------------------------------------------------------------------------------------");
        System.out.println("                                AVAILABLE BOOK COLLECTION                                 ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-28s | %-18s | %-8s | %-22s\n", "ID", "Book Title", "Author", "Price ($)",
                "Format Details");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).displayBook(i + 1);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}