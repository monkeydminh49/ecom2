package com.ecommerce.dao;

import com.ecommerce.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CommentDAOImpl implements CommentDAO {
    private List<Comment> comments;

    public Comment getCommentById(int id) { return null; }
    public void addComment(Comment comment) {}
    public void updateComment(Comment comment) {}
    public void deleteComment(int id) {}
}