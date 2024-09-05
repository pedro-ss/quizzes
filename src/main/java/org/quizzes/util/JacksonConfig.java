package org.quizzes.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.inject.Singleton;

@Singleton
public class JacksonConfig {
    
        public JacksonConfig(ObjectMapper mapper) {
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        }
}
