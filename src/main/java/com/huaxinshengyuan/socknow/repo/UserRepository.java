package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.User;



public interface UserRepository extends GraphRepository<User>,
        RelationshipOperationsRepository<User> {
   
}
