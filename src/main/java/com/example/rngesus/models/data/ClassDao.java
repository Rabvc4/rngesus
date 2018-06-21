package com.example.rngesus.models.data;

import com.example.rngesus.models.forms.CharacterClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ClassDao extends CrudRepository<CharacterClass, Integer> {
}
