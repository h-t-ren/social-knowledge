package com.huaxinshengyuan.socknow.repo;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.mapper.PublicationPermission;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;


public interface UserRepository extends GraphRepository<User>,
        RelationshipOperationsRepository<User> {
   
    @Query("start user=node({0})"+
    " match user-[r:"+RelationType.UserSecuredPublication+"]->publication return publication, r.permission")
	public List<PublicationPermission> getPublicationPermission(User user); 
}
