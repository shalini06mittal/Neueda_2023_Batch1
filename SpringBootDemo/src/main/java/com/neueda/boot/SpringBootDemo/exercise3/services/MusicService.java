package com.neueda.boot.SpringBootDemo.exercise3.services;

import com.neueda.boot.SpringBootDemo.exercise3.entities.MyMusic;
import com.neueda.boot.SpringBootDemo.exercise3.exceptions.MusicNotFoundException;
import com.neueda.boot.SpringBootDemo.exercise3.repo.IMusicRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepo repo;

    @Override
    public MyMusic addMusicData(MyMusic data) {
        return repo.save(data);
    }

    @Override
    public MyMusic deleteMusicData(String name) {

        MyMusic m1 =repo.findByName(name);
        repo.delete(m1);
        return m1;

    }

    @Override
    public List<MyMusic> getAllMusicData() {
        return
                repo.findAll();
    }

    @Override
    public MyMusic getMusicByName(String name) throws MusicNotFoundException {
        return repo.findByName(name);
    }

    @Override
    public MyMusic updateMusicData(String name , MyMusic musicData) throws MusicNotFoundException {
        MyMusic music =  repo.findByName(name);
        music.setArtists(musicData.getArtists());
        music.setName(musicData.getName());
        music.setGenre(musicData.getGenre());

        repo.save(music);
        return music;
    }
}