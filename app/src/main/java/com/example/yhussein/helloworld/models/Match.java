package com.example.yhussein.helloworld.models;

public class Match {
    private String imageUrl;
    private String lat;
    private Boolean liked;
    private String longitude;
    private String name;
    private String uid;

    public Match() {
    }

    public Match(String imageUrl, String lat, Boolean liked, String longitude, String name, String uid) {
        this.imageUrl = imageUrl;
        this.lat = lat;
        this.liked = liked;
        this.longitude = longitude;
        this.name = name;
        this.uid = uid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
