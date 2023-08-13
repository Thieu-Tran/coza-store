package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.BlogResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogServiceImp {
    List<BlogResponse> getAllBlog();

    BlogResponse getBlogById(int id);
}
