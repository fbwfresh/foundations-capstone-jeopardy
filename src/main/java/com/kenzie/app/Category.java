package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    @JsonProperty("canon")
    private String canon;
    @JsonProperty("title")
    private String title;
    @JsonProperty("id")
    private String id;

    public String getCanon() {
        return canon;
    }

    public void setCanon(String canon) {
        this.canon = canon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
