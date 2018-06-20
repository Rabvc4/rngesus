package com.example.rngesus.models.data;

import com.example.rngesus.models.forms.Trait;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TraitDao extends CrudRepository<Trait, Integer> {
}
