package AmazonContractOOP.LibraryManagementSystem;

import java.util.*;

public class User {
    String name;
    List<CheckoutRecord> checkedOut;

    public User(String name) {
        this.name = name;
        this.checkedOut = new ArrayList<>();
    }

    public void checkOut(CheckoutRecord checkoutRecord) {
        if (checkoutRecord == null)
            throw new IllegalArgumentException();
        this.checkedOut.add(checkoutRecord);
    }

}