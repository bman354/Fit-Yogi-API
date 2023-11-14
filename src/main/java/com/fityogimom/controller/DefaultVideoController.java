package com.fityogimom.controller;

import com.fityogimom.entities.Video;
import com.fityogimom.service.VideoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class DefaultVideoController implements VideoController{

    @Autowired
    private VideoService videoService;

    @Override
    public ResponseEntity<String> createVideo(Video video) {
        return null;
    }


    @Override
    public ResponseEntity<Video> getVideoById(int id) {
        return null;
    }


    @Override
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();

        if(videos.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(videos);
        }


    }


    @Override
    public ResponseEntity<String> updateVideo(Video video) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> deleteVideo(int id) {
        return null;
    }
}
