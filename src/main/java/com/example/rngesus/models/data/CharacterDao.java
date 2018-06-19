package com.example.rngesus.models.data;


import com.example.rngesus.models.character.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CharacterDao extends CrudRepository<PlayerCharacter, Integer> {
}
