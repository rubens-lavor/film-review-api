package com.filmreview.domain;

import java.util.Objects;

public enum ProfileType {
    READER(20, "BASIC"),
    BASIC(100, "ADVANCED"),
    ADVANCED(1000, "MODERATOR"),
    MODERATOR(1000, "MODERATOR");

    private final Integer initNextScore;

    private final String nextLevel;

    ProfileType(Integer initNextScore, String nextLevel){
        this.initNextScore = initNextScore;
        this.nextLevel = nextLevel;
    }

    public ProfileType level(Integer score) { // TODO: criar teste
        return this.initNextScore <= score ? ProfileType.valueOf(this.nextLevel) : this;
    }

    public Boolean isReader(){
        return this.equals(ProfileType.READER);
    }

}
