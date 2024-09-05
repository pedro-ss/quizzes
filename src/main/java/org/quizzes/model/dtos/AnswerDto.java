package org.quizzes.model.dtos;

import java.util.UUID;

public record AnswerDto(UUID identification, String description, Boolean correct) {
    
      public AnswerDto(UUID identification, String description, Boolean correct) {
        this.identification = identification;
        this.description = description;
        this.correct = correct;
    }
}
