package org.quizzes.model.dtos;

import java.util.List;
import java.util.UUID;

import org.quizzes.model.entities.Answer;

public record QuestionDto(UUID identification, String description, List<Answer> answers, UUID correctAnswerId) {
    
    public QuestionDto(UUID identification, String description, List<Answer> answers) {
        this.identification = identification;
        this.description = description;
        this.answers = answers;
    }
}
