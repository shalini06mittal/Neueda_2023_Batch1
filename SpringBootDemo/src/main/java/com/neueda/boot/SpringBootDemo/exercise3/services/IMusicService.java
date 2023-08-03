package com.neueda.boot.SpringBootDemo.exercise3.services;


import com.neueda.boot.SpringBootDemo.exercise3.entities.MusicData;
import com.neueda.boot.SpringBootDemo.exercise3.exceptions.MusicNotFoundException;

import java.util.List;

public interface IMusicService {

    public MusicData addMusicData(MusicData data);

    public MusicData deleteMusicData(String name);

    public List<MusicData> getAllMusicData();

    public MusicData getMusicByName(String name) throws MusicNotFoundException;

    public MusicData updateMusicData(String name , MusicData movieData) throws MusicNotFoundException;



}
