package com.huaxinshengyuan.socknow.domain;

import java.io.Serializable;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@SuppressWarnings("serial")
@NodeEntity
public abstract class KnowledgeNode implements Serializable {


	@GraphId Long nodeId;
	
	  @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        KnowledgeNode knowledgeNode = (KnowledgeNode) o;
	        if (nodeId == null) return super.equals(o);
	        return nodeId.equals(knowledgeNode.nodeId);

	    }

	    public Long getId() {
	        return nodeId;
	    }

	    @Override
	    public int hashCode() {

	        return nodeId != null ? nodeId.hashCode() : super.hashCode();
	    }

		public Long getNodeId() {
			return nodeId;
		}

		public void setNodeId(Long nodeId) {
			this.nodeId = nodeId;
		}
}
