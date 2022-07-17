package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty("canon")
    private String canon;
    @JsonProperty("aired")
    private String aired;

    public String getCanon() {
        return canon;
    }

    public void setCanon(String canon) {
        this.canon = canon;
    }

    public String getAired() {
        return aired;
    }

    public void setAired(String aired) {
        this.aired = aired;
    }
}
