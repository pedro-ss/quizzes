package org.quizzes.model.entities;

import java.util.List;
import java.util.UUID;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="question")
public class Question extends PanacheMongoEntityBase {
    
    @BsonId
    private UUID identification;
    private List<Answer> answers;
    private String description;
    private UUID subjectId;

    public Question() {}
    
    public Question(UUID identification, String description, List<Answer> answers) {
        this.identification = identification;
        this.description = description;
        this.answers = answers;
    }

    public UUID getIdentification() {
        return identification;
    }

    public void setIdentification(UUID identification) {
        this.identification = identification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    // Active record methods
    public static Question findById(UUID id) {
        return find("id", id).firstResult();
    }

    public static List<Question> findAllQuestions(String idFornecido) {
        UUID id = UUID.fromString(idFornecido);
        return find("subject_id", id).firstResult();
    }

    public void persistQuestion() {
        persist();
    }

    public static boolean deleteById(UUID id) {
        return delete("id", id) > 0;
    }
}
