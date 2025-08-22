package org.stress.poc.model;

import lombok.Data;

import java.util.List;

@Data
public class DungeonGameRequest {

    private Long id;
    private Integer minimalHealth;
    private List<List<Integer>> dungeon;
}
