package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.BlogEntity;
import com.cyber.cozastore.entity.CommentEntity;
import com.cyber.cozastore.payload.request.CommentRequest;
import com.cyber.cozastore.payload.response.CommentResponse;
import com.cyber.cozastore.repository.CommentRepository;
import com.cyber.cozastore.service.imp.CommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements CommentServiceImp {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentResponse> getCommentByBlogId(int id) {
        List<CommentEntity> list = commentRepository.findByBlogId(id);
        List<CommentResponse> responseList = new ArrayList<>();

        for (CommentEntity data:list) {
            CommentResponse response = new CommentResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            response.setEmail(data.getEmail());
            response.setWebsite(data.getWebsite());
            response.setComment(data.getComment());
            response.setCreateDate(data.getCreateDate());
            response.setBlogId(data.getBlog().getId());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public boolean addComment(CommentRequest request) {
        boolean isSuccess=false;
        try {
            CommentEntity comment = new CommentEntity();

            comment.setName(request.getName());
            comment.setEmail(request.getEmail());
            comment.setWebsite(request.getWebsite());
            comment.setComment(request.getComment());
            comment.setBlog(request.getBlog());

            commentRepository.save(comment);
            isSuccess=true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isSuccess;
    }

}
