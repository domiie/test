package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BorrowingEntity {

    @Id
    @GeneratedValue
    private Long id;

    //Sluzi na previazanie entít
    @ManyToOne
    private CustomerEntity borrower;

    @ManyToOne
    private BookEntity book;

    public Long getId() {
        return id;
    }

    public CustomerEntity getBorrower() {
        return borrower;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBorrower(CustomerEntity borrower) {
        this.borrower = borrower;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
