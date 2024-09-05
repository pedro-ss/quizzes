package org.quizzes.model.entities;

import java.util.UUID;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="user")
public class User  extends PanacheMongoEntityBase {
    
    @BsonId
    private UUID identification;
    private Double score;
    private String name;

    public User() {}

    public User(UUID identification, Double score, String name) {
        this.identification = identification;
        this.score = score;
        this.name = name;
    }

    public UUID getIdentification() {
        return identification;
    }
    public void setIdentification(UUID identification) {
        this.identification = identification;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }

    // Active record methods
    public static User findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void persistUser() {
        persist();
    }

    public static boolean deleteById(UUID id) {
        return delete("id", id) > 0;
    }
}
