package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.request.CommentRequest;
import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.CommentResponse;
import com.cyber.cozastore.service.imp.CommentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentServiceImp commentServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentByBlogId(@PathVariable int id){
        List<CommentResponse> list = commentServiceImp.getCommentByBlogId(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addComment(@Valid @RequestBody CommentRequest request){
        boolean isSuccess = commentServiceImp.addComment(request);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
