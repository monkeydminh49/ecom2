package com.ecommerce.dao.impl;

import com.ecommerce.model.Book;
import com.ecommerce.dao.BookDAO;
import com.ecommerce.dao.repo.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class BookDAOImpl implements BookDAO {

    private final ItemRepository itemRepository;

    @Override
    public List<Book> getAllBooks() {
        var item = itemRepository.findAll();
        //cast
        List<Book> books = new ArrayList<>();
        for (var i : item) {
            books.add((Book) i);
        }
        return books;
    }

    @Override
    public Book getBookById(int id) {
        var item = itemRepository.findById(id);
        if (item.isPresent()) {
            return (Book) item.get();
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        var item = itemRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        var item = itemRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        itemRepository.deleteById(id);
    }
}
