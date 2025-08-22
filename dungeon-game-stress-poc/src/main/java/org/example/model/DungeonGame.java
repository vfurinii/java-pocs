package org.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "dungeon_game")
@Data
public class DungeonGame {
    @Id
    @Column("id")
    private Long id;

    @Column("minimal_health")
    private Integer minimal_health;

    @Column("execution_id")
    private String execution_id;
}
