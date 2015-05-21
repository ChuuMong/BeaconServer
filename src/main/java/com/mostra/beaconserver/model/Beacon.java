package com.mostra.beaconserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JongHunLee on 2015-05-21.
 */

@Document(collection = "beacon")
public class Beacon implements Serializable {
    @Id
    private String id;

    @Indexed
    private String uuid;
    private String title;
    private List<String> picture;
    private String content;

    @PersistenceConstructor
    public Beacon() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.id = ObjectId.get().toString();
        picture = new ArrayList<>();
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
        return title;
    }

    public void setTitleText(String title) {
        this.title = title;
    }

    public List<String> getPictureURL() {
        return picture;
    }

    public void setPictureURL(List<String> picture) {
        this.picture = picture;
    }

    public void addPicureURL(String url) {
        picture.add(url);
    }

    public String getContentText() {
        return content;
    }

    public void setContentText(String content) {
        this.content = content;
    }
}
