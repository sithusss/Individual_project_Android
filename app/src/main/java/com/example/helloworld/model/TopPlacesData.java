package com.example.helloworld.model;

public class TopPlacesData {

    String placeName;
    String district;
    String grade;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public TopPlacesData(String placeName, String district, String grade, Integer imageUrl) {
        this.placeName = placeName;
        this.district = district;
        this.grade = grade;
        this.imageUrl = imageUrl;
    }

}

