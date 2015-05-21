package com.mostra.beaconserver.model.vo;

import com.mostra.beaconserver.model.Beacon;

import java.util.List;

/**
 * Created by JongHunLee on 2015-05-21.
 */
public class BeaconVo {
    String id;
    String uuid;
    String titleText;
    List<String> pictureURL;
    String contentText;

    public BeaconVo() {
        // TODO Auto-generated constructor stub
    }

    public BeaconVo(Beacon beacon) {
        this.id = beacon.getId();
        this.uuid = beacon.getUuid();
        this.titleText = beacon.getTitleText();
        this.pictureURL = beacon.getPictureURL();
        this.contentText = beacon.getContentText();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public List<String> getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(List<String> pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
