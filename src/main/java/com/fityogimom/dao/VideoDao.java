package com.fityogimom.dao;

import com.fityogimom.entities.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VideoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ClientDao.class);

    public List<Video> getAllVideos() {
        String fetchString = "SELECT * FROM Video";

        return jdbcTemplate.query(fetchString, ((rs, rowNum) -> {
            Video video = new Video();

            video.setId(rs.getInt("id"));
            video.setVideoLink(rs.getString("videoLink"));

            return video;
        }));

    }

    public void createVideo(Video video){
        try {
            String dbString = "INSERT INTO Video (videoLink) VALUES (?)";
        } catch(Exception e){
            System.out.println("MySQL Error: " + e);
        }
    }

    public void updateVideo(Video oldVideo, Video newVideo){
        //// TODO: 11/13/2023 Impl

    }
    public void deleteVideo(Video video){
        //TODO impl
    }
}
