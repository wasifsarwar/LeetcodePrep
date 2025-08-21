package AmazonContractOOP.LibraryManagementSystem;

import java.util.Objects;

public class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object == this)
            return true;

        if (!(object instanceof Book))
            return false;

        Book other = (Book) object;
        return Objects.equals(this.title, other.title) && Objects.equals(this.author, other.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.author);
    }
}
