package com.fityogimom.controller;

import com.fityogimom.entities.Video;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/video")
public interface VideoController {

    /*
    Create Video
     */
    @PostMapping("/create")
    ResponseEntity<String> createVideo(@RequestBody Video video);

    /*
    Read Video
     */

    @GetMapping("/get")
    ResponseEntity<Video> getVideoById(@RequestParam int id);

    @GetMapping("")
    ResponseEntity<List<Video>> getAllVideos();

    /*
    Update Video
     */
    @PostMapping("/update")
    ResponseEntity<String> updateVideo(@RequestBody Video video);

    /*
    Delete Video
     */
    @DeleteMapping("/delete")
    ResponseEntity<String> deleteVideo(@RequestParam int id);
}

