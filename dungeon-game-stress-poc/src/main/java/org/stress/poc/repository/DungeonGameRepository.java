package org.stress.poc.repository;

import org.stress.poc.model.DungeonGameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonGameRepository extends CrudRepository<DungeonGameEntity, String> {
}
