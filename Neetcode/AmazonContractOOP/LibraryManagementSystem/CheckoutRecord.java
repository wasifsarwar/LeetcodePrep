package AmazonContractOOP.LibraryManagementSystem;

import java.time.LocalDateTime;

public class CheckoutRecord {
    User user;
    Book book;
    LocalDateTime checkedout;
    LocalDateTime expiration;

    public CheckoutRecord(User user, Book book, LocalDateTime expDate) {
        this.user = user;
        this.book = book;
        this.checkedout = LocalDateTime.now();
        this.expiration = expDate;
    }
}
