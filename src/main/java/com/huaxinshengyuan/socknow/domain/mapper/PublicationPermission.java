package com.huaxinshengyuan.socknow.domain.mapper;

import org.springframework.data.neo4j.annotation.MapResult;
import org.springframework.data.neo4j.annotation.ResultColumn;

import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.enums.Permission;

@MapResult
public interface PublicationPermission {

	@ResultColumn("publication")
	public Publication getPublication();
	
	@ResultColumn("r.permission")
	public Permission getPerssion();
}
