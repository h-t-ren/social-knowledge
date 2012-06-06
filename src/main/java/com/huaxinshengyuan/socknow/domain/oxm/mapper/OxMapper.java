package com.huaxinshengyuan.socknow.domain.oxm.mapper;

import java.io.IOException;

public interface OxMapper {
	public abstract void writeObjectToXml(Object object, String filename)
			throws IOException;

	public abstract Object readObjectFromXml(String filename)
			throws IOException;
}
