package com.example.rngesus.models.data;

import com.example.rngesus.models.CharacterClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ClassDao extends CrudRepository<CharacterClass, Integer> {

    List<CharacterClass> findByName(String name);

}
