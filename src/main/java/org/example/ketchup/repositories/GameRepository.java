package org.example.ketchup.repositories;

import org.example.ketchup.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface
GameRepository extends MongoRepository<Game,String> {
}
