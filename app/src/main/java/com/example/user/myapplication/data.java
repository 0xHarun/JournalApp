package com.example.user.myapplication;

public class data {
    String titleID;
    String titleName;
    String descriptionName;


    public data(){

    }

    public data(String titleID, String titleName, String descriptionName) {
        this.titleID = titleID;
        this.titleName = titleName;
        this.descriptionName = descriptionName;
    }

    public String getTitleID() {
        return titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

       public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

}
