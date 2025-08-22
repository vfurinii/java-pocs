package org.stress.poc.service;

import org.stress.poc.game.DungeonGame;
import org.stress.poc.model.DungeonGameEntity;
import org.stress.poc.model.DungeonGameRequest;
import org.stress.poc.model.DungeonGameResponse;
import org.stress.poc.repository.DungeonGameRepository;
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

    public List<DungeonGameEntity> findAll() {
        return StreamSupport.stream(dungeonGameRepository.findAll().spliterator(), false).toList();
    }

    public DungeonGameResponse calculateMinimumHealth(DungeonGameRequest request) {
        DungeonGame game = new DungeonGame();

        game.calculateMinimumHealth(request);

//        var response = dungeonGameRepository.save();

        return new DungeonGameResponse(1L, 1);
    }

    public void save() {
        System.out.println("saved");
    }
}
