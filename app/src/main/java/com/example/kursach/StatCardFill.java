package com.example.kursach;

import android.widget.ImageView;
import android.widget.TextView;

public class StatCardFill {
    String title;
    String vote;
    String poster;
    String year;
    String genre;
    Integer id;

    public StatCardFill(Integer id, String title, String vote, String poster, String year, String genre) {
        this.id = id;
        this.title = title;
        this.vote = vote;
        this.poster = poster;
        this.year = year;
        this.genre = genre;
    }

    public StatCardFill() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
