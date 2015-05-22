package com.mostra.beaconserver.repository;

import com.mostra.beaconserver.model.Beacon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by JongHunLee on 2015-05-21.
 */

@Repository
public class BeaconRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insert(Beacon beacon) {
        mongoTemplate.insert(beacon);
    }

    public List<Beacon> getBeacons() {
        return mongoTemplate.findAll(Beacon.class);
    }

    public void deleteBeacon(Beacon beacon) {
        Query query = new Query(new Criteria("uuid").is(beacon.getUuid()));
        mongoTemplate.remove(query);
    }

    public void updateBeacon(Beacon beacon) {
        Query query = new Query(new Criteria("uuid").is(beacon.getUuid()));

        Update update = new Update();
        update.set("uuid", beacon.getUuid());
        update.set("title", beacon.getContentText());
        update.set("picture", beacon.getPictureURL());
        update.set("content", beacon.getContentText());

        mongoTemplate.updateFirst(query, update, Beacon.class);
    }

    public Beacon getBeacon(String uuid) {
        Query query = new Query(new Criteria("uuid").is(uuid));
        Beacon beacon = mongoTemplate.findOne(query, Beacon.class);
        if (beacon != null) return beacon;
        else return null;
    }
}
