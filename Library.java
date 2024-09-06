package LibraryManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private Map<Integer, Member> members;
    private List<BorrowRecord> borrowRecords;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new HashMap<>();
        this.borrowRecords = new ArrayList<>();
    }

    // Book Management
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Member Management
    public void registerMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void removeMember(int memberId) {
        members.remove(memberId);
    }

    public Member getMemberById(int memberId) {
        return members.get(memberId);
    }

    // Borrowing Books
    public boolean borrowBook(Member member, Book book) {
        if (book.isAvailable() && member.getBorrowedBooks().size() < 5) {
            book.setAvailable(false);
            member.getBorrowedBooks().add(book);
            BorrowRecord record = new BorrowRecord(book, member, LocalDate.now());
            borrowRecords.add(record);
            return true;
        }
        return false;
    }

     public boolean returnBook(Member member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            member.getBorrowedBooks().remove(book);
            for (BorrowRecord record : borrowRecords) {
                if (record.getBook().equals(book) && record.getMember().equals(member)) {
                    record.setReturnDate(LocalDate.now());
                    return true;
                }
            }
        }
        return false;
    }

     public List<BorrowRecord> getBorrowingHistory(Member member) {
        List<BorrowRecord> history = new ArrayList<>();
        for (BorrowRecord record : borrowRecords) {
            if (record.getMember().equals(member)) {
                history.add(record);
            }
        }
        return history;
    }
}
