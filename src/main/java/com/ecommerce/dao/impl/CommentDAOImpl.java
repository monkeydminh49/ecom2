package com.ecommerce.dao.impl;

import com.ecommerce.dao.CommentDAO;
import com.ecommerce.model.Comment;
import com.ecommerce.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class CommentDAOImpl implements CommentDAO {
    private final List<Comment> comments = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Comment getCommentById(int id) {
        return generateRandomComment(id);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        // Simulate update by replacing the comment with the same id
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == comment.getId()) {
                comments.set(i, comment);
                return;
            }
        }
    }

    @Override
    public void deleteComment(int id) {
        comments.removeIf(comment -> comment.getId() == id);
    }

    @Override
    public List<Comment> getComments() {
        List<Comment> randomComments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomComments.add(generateRandomComment(i));
        }
        return randomComments;
    }

    private Comment generateRandomComment(int id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setContent("Random comment text " + random.nextInt(100));
        var customer = new Customer();
        customer.setId(random.nextInt(100));
        comment.setAuthor(customer);
        return comment;
    }
}