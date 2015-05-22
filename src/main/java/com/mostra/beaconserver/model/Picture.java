package com.mostra.beaconserver.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JongHunLee on 2015-05-21.
 */
public class Picture {
    private List<String> pictureList;

    public Picture() {
        this.pictureList = new ArrayList<>();
    }

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }
}
