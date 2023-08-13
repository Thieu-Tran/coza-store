package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.request.CommentRequest;
import com.cyber.cozastore.payload.response.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentServiceImp {
    List<CommentResponse> getCommentByBlogId(int id);
    boolean addComment(CommentRequest request);

}
