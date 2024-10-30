package com.ecommerce.dao;

import com.ecommerce.model.Comment;

public interface CommentDAO {
    Comment getCommentById(int id);
    void addComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(int id);
}