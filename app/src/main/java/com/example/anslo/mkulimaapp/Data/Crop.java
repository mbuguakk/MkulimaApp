package com.example.anslo.mkulimaapp.Data;

/**
 * Created by anslo on 10/27/18.
 */

public class Crop {
    private static final int NO_IMAGE_PROVIDED=-1;
    private String cropName;
    private String soilPh;
    private int imageResourceId;


    /**
     * create a new Crop object
     * @param cropName  name of the crop
     * @param soilPh  pH value of the crop
     * @param imageResourceId image of the crop
     */
    public Crop(String cropName,String soilPh,int imageResourceId){
        this.cropName=cropName;
        this.soilPh=soilPh;
        this.imageResourceId=imageResourceId;
    }

    public String getCropName() {
        return cropName;
    }

    public String getSoilPh() {
        return soilPh;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    /**
     *  Returns whether or not there is an image for this word
     */
    public boolean hasImage(){
        return imageResourceId!=NO_IMAGE_PROVIDED;
    }
}
