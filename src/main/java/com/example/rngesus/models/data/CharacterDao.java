package com.example.rngesus.models.data;

import com.example.rngesus.models.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CharacterDao extends CrudRepository<PlayerCharacter, Integer> {

    List<PlayerCharacter> findByUserId(int id);

//    List<User> findByUsername(String username);

}
