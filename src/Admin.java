class Admin {
    LinkedList<Book> unavailableBooks;

    public Admin() {
        this.unavailableBooks = new LinkedList<>();
    }

    public void trackUnavailableBooks(LinkedList<Book> allBooks) {
        unavailableBooks.clear();
        for (Book book : allBooks) {
            if (book.availableCopies == 0) {
                unavailableBooks.add(book);
            }
        }
    }

    public void viewUnavailableBooks() {
        System.out.println("Unavailable Books:");
        for (Book book : unavailableBooks) {
            System.out.println(book);
        }
    }
}