package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.Group;


public interface GroupRepository extends GraphRepository<Group>,
        RelationshipOperationsRepository<Group> {
   
}
