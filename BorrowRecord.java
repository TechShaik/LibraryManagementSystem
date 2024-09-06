package LibraryManagement;

import java.time.LocalDate;

public class BorrowRecord {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private double fine;

    public BorrowRecord(Book book, Member member, LocalDate borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
        this.fine = 0.0;
    }

     public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        calculateFine();
    }

    public double getFine() {
        return fine;
    }

    private void calculateFine() {
        if (returnDate != null) {
            long daysBorrowed = borrowDate.until(returnDate).getDays();
            if (daysBorrowed > 30) {
                this.fine = (daysBorrowed - 30) * 1.0;  
            }
        }
    }

     public String toString() {
        return  
                "Borrowed :  " + book +
                "member = " + member +
                "borrowDate = " + borrowDate +
                "returnDate =  " + returnDate +
                "fine = "  + fine;
    }
}
