package com.xt.redis;

import com.xt.redis.base.BasePrefix;

public class LinkKey extends BasePrefix {

	private LinkKey(String prefix) {
		super(prefix);
	}
	public static LinkKey getById = new LinkKey("id");
	public static LinkKey getByTitle = new LinkKey("name");
	public static LinkKey getIndex = new LinkKey("index");
}
