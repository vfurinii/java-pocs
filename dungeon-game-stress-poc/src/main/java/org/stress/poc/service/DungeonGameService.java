package org.stress.poc.service;

import org.stress.poc.game.DungeonGame;
import org.stress.poc.model.DungeonGameResponse;
import org.stress.poc.repository.DungeonGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DungeonGameService {

    private final DungeonGameRepository dungeonGameRepository;
    private final DungeonGame dungeonGame;

    @Autowired
    public DungeonGameService(DungeonGameRepository dungeonGameRepository) {
        this.dungeonGameRepository = dungeonGameRepository;
        this.dungeonGame = new DungeonGame();
    }

    public List<DungeonGameResponse> findAll() {
        return StreamSupport.stream(dungeonGameRepository.findAll().spliterator(), false).toList();
    }

    public DungeonGameResponse calculateAndSave(int[][] dungeon) {
        int result = dungeonGame.calculateMinimumHealth(dungeon);

        String dungeonData = Arrays.deepToString(dungeon);


        DungeonGameResponse dungeonResult = new DungeonGameResponse(
                dungeonData,
                result,
                dungeon.length,
                dungeon[0].length
        );

        return dungeonGameRepository.save(dungeonResult);
    }
}
