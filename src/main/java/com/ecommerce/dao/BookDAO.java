package com.ecommerce.dao;

import com.ecommerce.model.Book;
import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();
    Book getBookById(String idBook);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(String idBook);
}