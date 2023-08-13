package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.TagResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagServiceImp {
    List<TagResponse> getAllTag();
    List<TagResponse> getTagByBlogId(int id);
}
