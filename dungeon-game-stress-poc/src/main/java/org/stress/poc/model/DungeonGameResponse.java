package org.stress.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DungeonGameResponse {

    private Long id;
    private Integer minimalHealth;
    private List<List<Integer>> dungeon;


    public DungeonGameResponse(Long id, Integer minimalHealth) {
        this.id = id;
        this.minimalHealth = minimalHealth;
    }
}
