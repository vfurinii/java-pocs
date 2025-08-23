package org.stress.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "dungeon_game")
@Data
@AllArgsConstructor
public class DungeonGameEntity {
    @Id
    @Column("id")
    private Long id;

    @Column("minimal_health")
    private Integer minimal_health;

    @Column("execution_id")
    private String execution_id;


    public DungeonGameEntity(Integer minimal_health, String execution_id) {
        this.minimal_health = minimal_health;
        this.execution_id = execution_id;
    }
}
