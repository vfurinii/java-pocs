package org.example.service;

import org.example.model.DungeonGame;
import org.example.repository.DungeonGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DungeonGameService {

    @Autowired
    private DungeonGameRepository dungeonGameRepository;

    public DungeonGameService(DungeonGameRepository dungeonGameRepository) {
        this.dungeonGameRepository = dungeonGameRepository;
    }

    public List<DungeonGame> findAll() {
        return StreamSupport.stream(dungeonGameRepository.findAll().spliterator(), false).toList();
    }
}
