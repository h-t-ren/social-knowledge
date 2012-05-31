package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.Document;


public interface DocumentRepository extends GraphRepository<Document>,NamedIndexRepository<Document>,
RelationshipOperationsRepository<Document> {
}
