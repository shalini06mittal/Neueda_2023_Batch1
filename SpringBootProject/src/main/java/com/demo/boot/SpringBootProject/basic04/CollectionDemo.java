package com.demo.boot.SpringBootProject.basic04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class CollectionDemo {
    @Autowired
    private List<String> fruits;
    @Autowired
    private List<Author> authors;
    @Autowired
    private Set<Integer> ids;
    @Autowired
    private Map<String, Integer> map;
    public List<String> getFruits() {
        return fruits;
    }
    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public Set<Integer> getIds() {
        return ids;
    }
    public void setIds(Set<Integer> ids) {
        this.ids = ids;
    }
    public Map<String, Integer> getMap() {
        return map;
    }
    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

}
