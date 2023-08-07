package com.neueda.boot.SpringBootDemo.exercise3.services;

import com.neueda.boot.SpringBootDemo.exercise3.entities.MyMusic;
import com.neueda.boot.SpringBootDemo.exercise3.exceptions.MusicNotFoundException;
import org.bson.types.ObjectId;

import java.util.List;

public interface IMusicService {

    public MyMusic addMusicData(MyMusic data);

    public MyMusic deleteMusicData(String name);

    public List<MyMusic> getAllMusicData();

    public MyMusic getMusicByName(String name) throws MusicNotFoundException;

    public MyMusic updateMusicData(String name , MyMusic movieData) throws MusicNotFoundException;
}
