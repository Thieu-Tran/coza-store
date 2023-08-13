package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.BlogEntity;
import com.cyber.cozastore.payload.response.BlogResponse;
import com.cyber.cozastore.repository.BlogRepository;
import com.cyber.cozastore.service.imp.BlogServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements BlogServiceImp {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<BlogResponse> getAllBlog() {
        List<BlogEntity> list = blogRepository.findAll();
        List<BlogResponse> responseList = new ArrayList<>();

        for (BlogEntity data : list) {
            BlogResponse response = new BlogResponse();

            response.setId(data.getId());
            response.setImage(data.getImage());
            response.setTitle(data.getTitle());
            response.setDescription(data.getDescription());
            response.setContent(data.getContent());
            response.setCreateDate(data.getCreateDate());
            response.setUserId(data.getUser().getId());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public BlogResponse getBlogById(int id) {
        BlogEntity data = blogRepository.findById(id);
        BlogResponse response = new BlogResponse();

        response.setId(data.getId());
        response.setImage(data.getImage());
        response.setTitle(data.getTitle());
        response.setDescription(data.getDescription());
        response.setContent(data.getContent());
        response.setCreateDate(data.getCreateDate());
        response.setUserId(data.getUser().getId());

        return response;
    }
}
