package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.Author;


public interface AuthorRepository extends GraphRepository<Author>,NamedIndexRepository<Author>,
RelationshipOperationsRepository<Author> {
	
	Page<Author> findByOtherFirstName(String otherFirstName, Pageable pageable);
}
