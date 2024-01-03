package com.comfama.challengeanime.api.enums;

public enum RecommendationMessages {
    HIGH("Great, this is one of the best anime."),
    MODERATE("You may have fun."),
    LOW("I do not recommend it."),
    NA("NA");

    private final String message;

    RecommendationMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
