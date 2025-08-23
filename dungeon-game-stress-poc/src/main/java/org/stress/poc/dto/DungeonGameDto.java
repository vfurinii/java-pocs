package org.stress.poc.dto;


import lombok.Data;

import java.util.List;

@Data
public class DungeonGameDto {

    private String executionId;
    private Integer minimalHealth;
    private List<List<Integer>> dungeon;

    public DungeonGameDto(String id, Integer minimalHealth, List<List<Integer>> dungeon) {
        this.executionId = id;
        this.minimalHealth = minimalHealth;
        this.dungeon = dungeon;
    }

}
