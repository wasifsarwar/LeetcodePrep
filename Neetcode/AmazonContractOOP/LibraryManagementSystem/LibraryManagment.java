package AmazonContractOOP.LibraryManagementSystem;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Library Management System - Books, members, checkout/return functionality
 */

public class LibraryManagment {
    Map<Book, Integer> masterList;
    List<CheckoutRecord> activeCheckouts;

    public LibraryManagment() {
        masterList = new HashMap<>();
        activeCheckouts = new ArrayList<>();
    }

    public void fillMasterList(List<Book> books) {
        for (Book book : books) {
            masterList.put(book, masterList.getOrDefault(book, 0) + 1);
        }
    }

    public Book checkOutBook(User user, Book book) {
        if (masterList.containsKey(book) && masterList.get(book) >= 1) {
            masterList.put(book, masterList.get(book) - 1);
            LocalDateTime expDate = LocalDateTime.now().plusDays(14);
            CheckoutRecord checkoutRecord = new CheckoutRecord(user, book, expDate);
            user.checkedOut.add(checkoutRecord);
            activeCheckouts.add(checkoutRecord);
        } else {
            throw new IllegalArgumentException("book not available");
        }
        return book;
    }

    public Book returnBook(User user, Book book) {
        if (user == null || book == null)
            throw new IllegalArgumentException();
        CheckoutRecord toRemove = null;
        for (CheckoutRecord record : user.checkedOut) {
            if (record.book.equals(book)) {
                toRemove = record;
                break;
            }
        }
        if (!masterList.containsKey(book) || toRemove == null)
            throw new IllegalArgumentException("library cannot return book: not from this library");

        masterList.put(book, masterList.get(book) + 1);
        user.checkedOut.remove(toRemove);
        activeCheckouts.remove(toRemove);
        return book;
    }

    public boolean isBookAvailable(Book book) {
        if (book == null)
            return false;
        if (!masterList.containsKey(book) || masterList.get(book) < 1) {
            return false;
        }
        return true;
    }

    public int getAvailableCopies(Book book) {
        if (book == null)
            return 0;
        if (!masterList.containsKey(book)) {
            return 0;
        }
        return masterList.get(book);
    }

    public List<Book> getUserCheckoutBooks(User thisUser) {
        List<Book> res = new ArrayList<>();
        for (CheckoutRecord checkoutRecord : activeCheckouts) {
            User user = checkoutRecord.user;
            if (user.equals(thisUser)) {
                res.add(checkoutRecord.book);
            }
        }
        return res;

    }

    public List<Book> findBooksByAuthor(String author) {
        if (author == null)
            return new ArrayList<>();
        Set<Book> set = new HashSet<>();
        for (Book book : masterList.keySet()) {
            if (Objects.equals(book.author, author)) {
                set.add(book);
            }
        }
        return new ArrayList<>(set);
    }

}
