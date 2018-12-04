package com.example.rngesus.models.data;

import com.example.rngesus.models.ModifierSubType;
import com.example.rngesus.models.enumerations.ModifierType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ModifierSubTypeDao extends CrudRepository<ModifierSubType, Integer> {

    List<ModifierSubType> findByName(String name);

//    List<ModifierSubType> findByModifierType(ModifierType modifierType);

}
