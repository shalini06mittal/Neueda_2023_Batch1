package com.neueda.boot.SpringBootDemo.exercise3.repo;

import com.neueda.boot.SpringBootDemo.exercise3.entities.MusicData;

import com.neueda.boot.SpringBootDemo.exercise3.exceptions.MusicNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IMusicRepo extends MongoRepository<MusicData, ObjectId> {

    public MusicData findMusicDataByName(String name) throws MusicNotFoundException;

}
