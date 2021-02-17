package com.company;

import java.util.ArrayList;
import java.util.List;

public class Person implements Sentient {
    private List<Sentient> likes = new ArrayList<>();
    @Override
    public boolean likes(Sentient other) {
        return likes.contains(other);
    }

    @Override
    public void setLikes(Sentient other) {
        likes.add(other);
    }

    @Override
    public String getIdentity() {
        return this.getIdentity();
    }
}
