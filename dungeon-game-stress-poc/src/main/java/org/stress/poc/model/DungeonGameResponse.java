package org.stress.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Table(name = "dungeon_game_results")
public class DungeonGameResponse {

    @Id
    private Long id;
    @Column("dungeon_data")
    private String dungeonData;

    @Column("result")
    private Integer result;

    @Column("rows")
    private Integer rows;

    @Column("columns")
    private Integer columns;

    @Column("created_at")
    private LocalDateTime createdAt;

    public DungeonGameResponse() {
        this.createdAt = LocalDateTime.now();
    }

    public DungeonGameResponse(String dungeonData, Integer result, Integer rows, Integer columns) {
        this.dungeonData = dungeonData;
        this.result = result;
        this.rows = rows;
        this.columns = columns;
    }
}
