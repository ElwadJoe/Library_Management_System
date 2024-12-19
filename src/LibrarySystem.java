class LibrarySystem {
    LinkedList<Book> books;
    LinkedList<User> users;
    Admin admin;

    public LibrarySystem() {
        this.books = new LinkedList<>();
        this.users = new LinkedList<>();
        this.admin = new Admin();
    }

    public void addBook(String title, String author, int copies) {
        books.add(new Book(title, author, copies));
    }

    public void addUser(String name) {
        users.add(new User(name));
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.name.equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public void viewAllBooks() {
        System.out.println("Books in the Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}