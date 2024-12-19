public class Main {
    public static void main(String[] args) {
        LibrarySystem library = getLibrarySystem();

        User alice = library.findUser("Alice");
        User bob = library.findUser("Bob");
        User charlie = library.findUser("Charlie");

        Book gatsby = library.findBook("The Great Gatsby");
        Book nineteenEightyFour = library.findBook("1984");
        Book mobyDick = library.findBook("Moby Dick");

        // Alice borrows "The Great Gatsby"
        if (alice != null && gatsby != null) {
            alice.borrowBook(gatsby);
            alice.viewBorrowedBooks();
        }

        // Bob borrows "1984" and "Moby Dick"
        if (bob != null && nineteenEightyFour != null && mobyDick != null) {
            bob.borrowBook(nineteenEightyFour);
            bob.borrowBook(mobyDick);
            bob.viewBorrowedBooks();
        }

        // Admin tracks unavailable books
        library.admin.trackUnavailableBooks(library.books);
        library.admin.viewUnavailableBooks();

        // Charlie tries to borrow "Moby Dick" but it's unavailable
        if (charlie != null && mobyDick != null) {
            boolean success = charlie.borrowBook(mobyDick);
            System.out.println("Charlie borrowing 'Moby Dick': " + (success ? "Success" : "Failed"));
        }

        // Bob returns "1984"
        if (bob != null && nineteenEightyFour != null) {
            bob.returnBook(nineteenEightyFour);
            bob.viewBorrowedBooks();
        }

        // Admin updates and views unavailable books
        library.admin.trackUnavailableBooks(library.books);
        library.admin.viewUnavailableBooks();
    }

    private static LibrarySystem getLibrarySystem() {
        LibrarySystem library = new LibrarySystem();

        // Adding books
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 5);
        library.addBook("1984", "George Orwell", 3);
        library.addBook("To Kill a Mockingbird", "Harper Lee", 4);
        library.addBook("Moby Dick", "Herman Melville", 2);
        library.addBook("Pride and Prejudice", "Jane Austen", 6);

        // Adding users
        library.addUser("Alice");
        library.addUser("Bob");
        library.addUser("Charlie");

        // Example usage
        library.viewAllBooks();
        return library;
    }
}