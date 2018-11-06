package com.example.rngesus.models.data;

import com.example.rngesus.models.ClassLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ClassLevelDao extends CrudRepository<ClassLevel, Integer> {
}
