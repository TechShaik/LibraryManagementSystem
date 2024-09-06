package LibraryManagement;

public class Main {
    public static void main(String[] args) {
         Library library = new Library();

         Book book1 = new Book("Java Programming", " Dennies reiche", "123456");
        Book book2 = new Book("Python Programming", "Guido van russom", "654321");

         library.addBook(book1);
        library.addBook(book2);

         Member member1 = new Member("Alice", 1);
        Member member2 = new Member("Bob", 2);

         library.registerMember(member1);
        library.registerMember(member2);

         library.borrowBook(member1, book1);

         library.returnBook(member1, book1);

         System.out.println(library.getBorrowingHistory(member1));
    }
}
