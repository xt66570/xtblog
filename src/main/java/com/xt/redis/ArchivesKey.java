package com.xt.redis;

import com.xt.redis.base.BasePrefix;

public class ArchivesKey extends BasePrefix {

	private ArchivesKey(String prefix) {
		super(prefix);
	}
	public static ArchivesKey getById = new ArchivesKey("id");
	public static ArchivesKey getByTitle = new ArchivesKey("name");
	public static ArchivesKey getIndex = new ArchivesKey("index");
}
