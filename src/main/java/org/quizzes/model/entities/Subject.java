package org.quizzes.model.entities;

import java.util.List;
import java.util.UUID;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="subject")
public class Subject extends PanacheMongoEntityBase {

    @BsonId
    private UUID identification;
    private List<Question> questions;
    private String description;

    public Subject() {}

    public Subject(UUID identification, List<Question> questions, String description) {
        this.identification = identification;
        this.questions = questions;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public UUID getIdentification() {
        return identification;
    }

    public void setIdentification(UUID identification) {
        this.identification = identification;
    }

    // Active record methods
    public static Subject findById(UUID id) {
        return find("id", id).firstResult();
    }

    public static List<Subject> findAllSubjects(String idFornecido) {
        UUID id = UUID.fromString(idFornecido);
        return find("id", id).firstResult();
    }

    public void persistSubject() {
        persist();
    }

    public static boolean deleteById(UUID id) {
        return delete("id", id) > 0;
    }
}
