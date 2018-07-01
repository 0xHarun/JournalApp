package com.example.user.myapplication;

public class data {
    String titleID;
    String titleName;

    String descriptionName;
   // String date;

    public data(){

    }

    public data(String titleID, String titleName, String descriptionName) {
        this.titleID = titleID;
        this.titleName = titleName;
        this.descriptionName = descriptionName;
      //  this.date = date;
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

   // public String getdate() {
   //     return date;
   // }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

   // public void setdate(String date) {
  //      this.date = date;
  //  }
}
