package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private List<Book> books;

    public List<Book> getListOfBooks(){
        return this.books;
    }

    public BookController(){
        this.books = init();
    }

    private List<Book> init(){
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthorFirstName("Arthur");
        book1.setAuthorLastName("Doyle");
        book1.setTitle("Study in Red");
        book1.setIsbn("974-AD-41-C-F");
        book1.setBookCount(17);
        books.add(book1);
        book1.setId((long) books.indexOf(book1));

        Book book2 = new Book();
        book2.setAuthorFirstName("J.R.R.");
        book2.setAuthorLastName("Tolkien");
        book2.setTitle("The Hobbit");
        book2.setIsbn("128-XD-77-Q-F");
        book2.setBookCount(12);
        books.add(book2);
        book2.setId((long) books.indexOf(book2));

        return books;
    }


//    @GetMapping("/api/books")
//    public List<String> getBooksByTitle(@RequestParam(required = false) String title){
//
//        List<String> nonFilteredBooks = new ArrayList<>();
//
//        if(title == null){
//            for (Book book : books){
//                nonFilteredBooks.add(book.getTitle());
//            }
//            return nonFilteredBooks;
//        }
//
//        List<String> filteredBooks = new ArrayList<>();
//
//        for (Book book : books){
//            if(book.getTitle().equals(title)){
//                filteredBooks.add(book.getTitle());
//            }
//        }
//        return filteredBooks;
//    }

    //Hľadanie knihy podľa názvu
    @GetMapping("/api/books")
    public List<Book> getBooksByTitle(@RequestParam(required = false) String title){

        if(title == null){
            for (Book book : books){
                return this.books;
            }
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books){
            if(book.getTitle().equals(title)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    //Hľadanie knihy podľa ID
    @GetMapping("/api/books/{bookId}")
    public Book getBookById(@PathVariable Integer bookId){
        return this.books.get(bookId);
    }

    //Pridanie novej knihy
    @PostMapping("/api/books")
    public Integer createBook(@RequestBody Book book){
        this.books.add(book);
        return this.books.size() - 1;
    }

    //Zmazanie knihy podľa ID
    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.books.remove(this.books.get(bookId));
    }

    //Aktualizácia knihy podľa ID
    @PutMapping("/api/books/{bookId}")
    public void updateBook(@PathVariable Integer bookId, @RequestBody Book book){
        this.books.get(bookId).setTitle(book.getTitle());
        this.books.get(bookId).setAuthorFirstName(book.getAuthorFirstName());
        this.books.get(bookId).setAuthorLastName(book.getAuthorLastName());
        this.books.get(bookId).setBookCount(book.getBookCount());
        this.books.get(bookId).setIsbn(book.getIsbn());
        this.books.get(bookId).setId(book.getId());
    }
}
