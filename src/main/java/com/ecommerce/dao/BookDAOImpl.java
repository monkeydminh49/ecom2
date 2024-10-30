package com.ecommerce.dao;

import com.ecommerce.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    public List<Book> getAllBooks() { return null; }
    public Book getBookById(String idBook) { return null; }
    public void addBook(Book book) {}
    public void updateBook(Book book) {}
    public void deleteBook(String idBook) {}
}