package com.example.getfit;

public class football_train_ex {
    private String title;
    private int thumbnailResource;
    private String videoId;

    public football_train_ex(String title, int thumbnailResource, String videoId) {
        this.title = title;
        this.thumbnailResource = thumbnailResource;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public int getThumbnailResource() {
        return thumbnailResource;
    }

    public String getVideoId() {
        return videoId;
    }
}
