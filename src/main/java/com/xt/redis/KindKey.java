package com.xt.redis;

import com.xt.redis.base.BasePrefix;

public class KindKey extends BasePrefix {

	private KindKey(String prefix) {
		super(prefix);
	}
	public static KindKey getById = new KindKey("id");
	public static KindKey getByTitle = new KindKey("name");
	public static KindKey getIndex = new KindKey("index");
}
