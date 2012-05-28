package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.Publication;

public interface PublicationRepository extends GraphRepository<Publication>,
        RelationshipOperationsRepository<Publication> {
}
