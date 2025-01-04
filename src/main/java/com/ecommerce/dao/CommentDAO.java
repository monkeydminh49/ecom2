package com.ecommerce.dao;

import com.ecommerce.model.Comment;
import com.ecommerce.model.Customer;

import java.util.List;

public interface CommentDAO {
    Comment getCommentById(int id);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(int id);

    List<Comment> getComments();


}
