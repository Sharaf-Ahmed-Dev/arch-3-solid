import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookstoreManager manager = new BookstoreManager();
        Calculable calculator = new BillCalculator();
        Printable invoicePrinter = new ConsoleInvoicePrinter();
        NotificationService notifier = new ConsoleNotification();

        System.out.println("=========================================================================================");
        System.out.println("       WELCOME TO BOOKSTORE MANAGEMENT SYSTEM             ");
        System.out.println("=========================================================================================");

        System.out.print("\nPlease enter the customer's name: ");
        String customerName = scanner.nextLine().trim();

        while (customerName.isEmpty()) {
            System.out.print("Oops! Customer name is missing. Please enter it: ");
            customerName = scanner.nextLine().trim();
        }

        Customer customer = new Customer(101, customerName);
        Purchase purchase = new Purchase((int) (1000 + Math.random() * 9000), customer);

        boolean keepShopping = true;
        while (keepShopping) {
            manager.displayInventory();
            System.out.print("\nEnter the Book ID you wish to purchase (1 - "
                    + manager.getInventorySize() + ") or enter '0' when your book selection is complete: ");

            if (scanner.hasNextInt()) {
                int selection = scanner.nextInt();
                scanner.nextLine();

                if (selection == 0) {
                    keepShopping = false;
                } else if (selection > 0 && selection <= manager.getInventorySize()) {
                    Book selectedBook = manager.getBookByIndex(selection - 1);
                    purchase.addBook(selectedBook);
                } else {
                    System.out.println("[ERROR] Book selection failed. Enter a valid ID from the available list.");
                }
            } else {
                System.out.println("[WARNING] Incorrect input format. Enter a valid value to continue.");
                scanner.nextLine();
            }
        }

        if (!purchase.getPurchasedBooks().isEmpty()) {
            System.out.println("\nDISCOUNT OPTIONS");
            System.out.println("1. Regular Purchase - No Discount");
            System.out.println("2. Premium Member Savings - 10% OFF");
            System.out.println("3. Seasonal Book Festival Offer - 15% OFF");
            System.out.print("Enter your preferred discount option (1-3): ");

            DiscountStrategy strategy = new NoDiscount();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 2)
                    strategy = new MemberDiscount();
                else if (choice == 3)
                    strategy = new SeasonalDiscount();
            }

            Invoice invoice = purchase.checkout(calculator, strategy);
            invoicePrinter.printInvoice(invoice);
            notifier.sendNotification(" Transaction ID: BK-TXN-" + invoice.getInvoiceId());
        } else {
            System.out.println("\n[NOTICE] No books were selected for purchase. Checkout has been cancelled.");
        }

        System.out
                .println("\n=========================================================================================");
        System.out.println("Thank you for visiting our bookstore. We wish you a great reading journey. Goodbye!");
        System.out.println("=========================================================================================");

        scanner.close();
    }
}