package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.Publication;

public interface PublicationRepository extends GraphRepository<Publication>,NamedIndexRepository<Publication>,
        RelationshipOperationsRepository<Publication> {
	//public Page<Publication> findByTitleLike(String title, Pageable pageRequest);
}
