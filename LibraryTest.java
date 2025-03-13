import java.util.*;

public class LibraryTest
{
    public static void main(String[] args)
    {
        // Initialize Scanner
        Scanner scanner = new Scanner(System.in);
        Library library = Library.getInstance();

        // Add test items
        library.addItem(LibraryItemFactory.createItem("book", "Java Programming", 2020, "John Doe"));
        library.addItem(LibraryItemFactory.createItem("book", "Data Structures", 2019, "Jane Smith"));
        library.addItem(LibraryItemFactory.createItem("magazine", "Tech Weekly", 2021, "45"));

        // Loop for accessing system
        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. List available items");
            System.out.println("2. Search for an item");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Add new item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Items:");
                    library.listAvailableItems();
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Item foundItem = library.findItemByTitle(searchTitle);
                    if (foundItem != null) {
                        System.out.println("Found: " + foundItem.getTitle());
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Item itemToBorrow = library.findItemByTitle(borrowTitle);
                    if (itemToBorrow instanceof Book) {
                        try {
                            System.out.print("Enter your name: ");
                            String borrowerName = scanner.nextLine();
                            ((Book) itemToBorrow).borrowItem(borrowerName);
                            System.out.println("Book borrowed successfully.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Book not found or not borrowable.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Item itemToReturn = library.findItemByTitle(returnTitle);
                    if (itemToReturn instanceof Book) {
                        ((Book) itemToReturn).returnItem();
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter item type (book/magazine): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter author (if book) or issue number (if magazine): ");
                    String extraData = scanner.nextLine();
                    library.addItem(LibraryItemFactory.createItem(type, title, year, extraData));
                    System.out.println("Item added successfully.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
