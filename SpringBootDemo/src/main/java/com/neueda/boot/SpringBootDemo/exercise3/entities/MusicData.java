package com.neueda.boot.SpringBootDemo.exercise3.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class MusicData {
    @Id
    private ObjectId id;
    private String name;
    private String artistgroup;

   private List<String> genres = new ArrayList<>();

    public List<String> getGenres() {
        return genres;
    }


    public MusicData() {
    }


    public MusicData(ObjectId id, String name, String artistgroup, List<String> genres) {
        this.id = id;
        this.name = name;
        this.artistgroup = artistgroup;
        this.genres = genres;
    }



    public MusicData(ObjectId id, String name, String artistgroup) {
        this.id = id;
        this.name = name;
        this.artistgroup = artistgroup;
    }


    public MusicData(String name, String artistgroup, List<String> genres) {
        this.name = name;
        this.artistgroup = artistgroup;
        this.genres = genres;
    }

    public void setGenres(List<String > genres) {
        this.genres = genres;
    }

    public MusicData(ObjectId id) {
        this.id = id;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistgroup() {
        return artistgroup;
    }

    public void setArtistgroup(String artistgroup) {
        this.artistgroup = artistgroup;
    }

    @Override
    public String toString() {
        return "MovieData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistgroup='" + artistgroup + '\'' +
                ", genres=" +genres+
                '}';
    }


}
