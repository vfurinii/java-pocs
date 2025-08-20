package org.example.repository;

import org.example.model.DungeonGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonGameRepository extends CrudRepository<DungeonGame, String> {
}
