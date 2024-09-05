package org.quizzes.model.entities;

import java.util.List;
import java.util.UUID;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="answer")
public class Answer extends PanacheMongoEntityBase  {
    
    @BsonId
    private UUID identification;
    private String description;
    private Boolean correct;    

    public Answer() {}

    public Answer(UUID identification, String description, Boolean correct) {
        this.identification = identification;
        this.description = description;
        this.correct = correct;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getCorrect() {
        return correct;
    }
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
    public UUID getIdentification() {
        return identification;
    }
    public void setIdentification(UUID identification) {
        this.identification = identification;
    }

    // Active record methods
    public static Answer findById(UUID id) {
        return find("id", id).firstResult();
    }

    public static List<Answer> findAllAnswers(String idFornecido) {
        UUID id = UUID.fromString(idFornecido);
        return find("question_id", id).firstResult();
    }

    public void persistAnswer() {
        persist();
    }

    public static boolean deleteById(UUID id) {
        return delete("id", id) > 0;
    }

}
