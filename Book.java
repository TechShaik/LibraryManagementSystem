package LibraryManagement;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;  
    }

     public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

     public int hashCode() {
        return Objects.hash(isbn);
    }

     public String toString() {
        return
                "Book title = " + title + '\n' +
                " author = " + author + '\n' +
                " isbn = " + isbn + '\n' +
                "available = " + available;
        
     }
}
     
