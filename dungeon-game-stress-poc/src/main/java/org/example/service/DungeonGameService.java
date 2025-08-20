package org.example.service;

import org.example.model.DungeonGame;
import org.example.repository.DungeonGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DungeonGameService {

    @Autowired
    private DungeonGameRepository dungeonGameRepository;

    public DungeonGameService(DungeonGameRepository dungeonGameRepository) {
        this.dungeonGameRepository = dungeonGameRepository;
    }

    public Iterable<DungeonGame> findAll() {
        return dungeonGameRepository.findAll();
    }
}
