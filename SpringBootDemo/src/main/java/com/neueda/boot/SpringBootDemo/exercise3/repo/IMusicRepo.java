package com.neueda.boot.SpringBootDemo.exercise3.repo;

import com.neueda.boot.SpringBootDemo.exercise3.entities.MyMusic;
import com.neueda.boot.SpringBootDemo.exercise3.exceptions.MusicNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IMusicRepo extends MongoRepository<MyMusic, String> {

    @Query("{'name':'?0'}")
    MyMusic findByName(String name);

    @Query(value="{genre:'?0'}",fields="{'name':1,'artists':1}")
    List<MyMusic> findAll(String genre);

}
