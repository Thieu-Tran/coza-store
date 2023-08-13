package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.TagBlogEntity;
import com.cyber.cozastore.entity.TagEntity;
import com.cyber.cozastore.payload.response.TagResponse;
import com.cyber.cozastore.repository.TagRepository;
import com.cyber.cozastore.service.imp.TagServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService implements TagServiceImp {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<TagResponse> getAllTag() {
        List<TagEntity> list = tagRepository.findAll();
        List<TagResponse> responseList = new ArrayList<>();

        for (TagEntity data:list) {
            TagResponse response = new TagResponse();
            response.setId(data.getId());
            response.setName(data.getName());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public List<TagResponse> getTagByBlogId(int id) {
        List<TagEntity> list = tagRepository.getTagByBlogId(id);
        List<TagResponse> responseList = new ArrayList<>();

        for (TagEntity data:list) {
            TagResponse response = new TagResponse();
            response.setId(data.getId());
            response.setName(data.getName());

            responseList.add(response);
        }

        return responseList;
    }
}
