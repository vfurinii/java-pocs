package org.stress.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.stress.poc.model.DungeonGameResponse;

@Repository
public interface DungeonGameRepository extends CrudRepository<DungeonGameResponse, String> {
}
