package org.example.dto;


import lombok.Data;

@Data
public class DungeonGameDto {

    private Long id;
    private Integer minimalHealth;

    public DungeonGameDto(Long id, Integer minimalHealth) {
        this.id = id;
        this.minimalHealth = minimalHealth;
    }

}
