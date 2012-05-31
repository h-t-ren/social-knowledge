package com.huaxinshengyuan.socknow.repo;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.NamedIndexRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import com.huaxinshengyuan.socknow.domain.Keyword;

public interface KeywordRepository extends GraphRepository<Keyword>,NamedIndexRepository<Keyword>,
RelationshipOperationsRepository<Keyword> {
}
