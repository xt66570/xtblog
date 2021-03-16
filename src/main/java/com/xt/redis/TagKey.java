package com.xt.redis;

import com.xt.redis.base.BasePrefix;

public class TagKey extends BasePrefix {
	/**
	 * 这是一个构造方法
	 * @param prefix  redis key 前缀的 一部分
	 */
	private TagKey(String prefix) {

		super(prefix); //调用父类的构造方法
	}
	public static TagKey getById = new TagKey("id");	//这个类的方法《用来实例化这个类，并传参》
	public static TagKey getByTitle = new TagKey("name");
	public static TagKey getIndex = new TagKey("index");
}
