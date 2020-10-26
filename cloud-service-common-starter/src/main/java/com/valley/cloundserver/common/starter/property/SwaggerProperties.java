package com.valley.cloundserver.common.starter.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author valley
 * @version 1.0 2020/1/15
 * @description：swagger文档页面显示字段
 */
@ConfigurationProperties(prefix = "application.swagger")
public class SwaggerProperties {
	/**
	 * 项目标题描述
	 */
	private String title;

	/**
	 * 项目作者
	 */
	private String author;

	/**
	 * 项目版本号
	 */
	private String version;

	/**
	 * 是否开启
	 */
	private boolean enable;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
