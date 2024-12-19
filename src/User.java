class User {
    String name;
    LinkedList<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new LinkedList<>();
    }

    public boolean borrowBook(Book book) {
        if (book.borrowBook()) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
        }
    }

    public void viewBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }
}