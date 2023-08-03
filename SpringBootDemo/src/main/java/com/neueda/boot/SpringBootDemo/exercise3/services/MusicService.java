package com.neueda.boot.SpringBootDemo.exercise3.services;



import com.neueda.boot.SpringBootDemo.exercise3.entities.MusicData;
import com.neueda.boot.SpringBootDemo.exercise3.exceptions.MusicNotFoundException;
import com.neueda.boot.SpringBootDemo.exercise3.repo.IMusicRepo;

import java.util.List;

public class MusicService implements IMusicService {

    private IMusicRepo repo;

    public MusicService(IMusicRepo repo) {
        this.repo = repo;
    }

    @Override
    public MusicData addMusicData(MusicData data) {
        return null;
    }



    @Override
    public MusicData deleteMusicData(String name) {
        return null;
    }

    @Override
    public List<MusicData> getAllMusicData() {
        return null;
    }

    @Override
    public MusicData getMusicByName(String name) {
        return null;
    }

    @Override
    public MusicData updateMusicData(String name , MusicData movieData) {
        return null;
    }
}