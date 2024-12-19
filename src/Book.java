class Book {
    String title;
    String author;
    int totalCopies;
    int availableCopies;

    public Book(String title, String author, int totalCopies) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available Copies: " + availableCopies;
    }
}