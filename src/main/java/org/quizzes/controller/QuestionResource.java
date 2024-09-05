package org.quizzes.controller;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.quizzes.model.entities.Question;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {
    
    @GET
    public List<Question> getAllQuestions(String idFornecido) {
        return Question.findAllQuestions(idFornecido);
    }

    @POST
    @Transactional
    public Response createQuestion(Question question) {
        question.persist();
        return Response.status(Response.Status.CREATED).entity(question).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateQuestion(@PathParam("id") Long id, Question updatedQuestion) {
        Question question = Question.findById(id);
        if (question == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        question.setDescription(updatedQuestion.getDescription());
        question.getAnswers().clear();
        question.getAnswers().addAll(updatedQuestion.getAnswers());
        question.persist();
        return Response.ok(question).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteQuestion(@PathParam("id") Long id) {
        boolean deleted = Question.deleteById(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
