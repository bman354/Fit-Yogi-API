package com.fityogimom.service;

import com.fityogimom.dao.VideoDao;
import com.fityogimom.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoDao videoDao;

    public List<Video> getAllVideos() {

        return videoDao.getAllVideos();

    }

    public void createVideo(Video video){
        videoDao.createVideo(video);
    }
    public void updateVideo(Video oldVideo, Video newData){
        videoDao.updateVideo(oldVideo, newData);
    }

    public void deleteVideo(Video video){
        videoDao.deleteVideo(video);
    }


}
