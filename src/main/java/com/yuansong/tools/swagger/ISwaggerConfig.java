package com.yuansong.tools.swagger;

import springfox.documentation.service.Tag;

public interface ISwaggerConfig {
	
	/**
	 * 是否启用
	 * @return
	 */
	public Boolean getEnable();
	
	/**
	 * 标题
	 * @return
	 */
	public String getTitle();
	
	/**
	 * 描述
	 * @return
	 */
	public String getDescription();
	
	/**
	 * 版本
	 * @return
	 */
	public String getVersion();
	
	/**
	 * 扫描的包路径 如 com.yuansong com.zillion，使用逗号分隔
	 * @return
	 */
	public String getBasePackage();
	
	/**
	 * 
	 * @return
	 */
	default public Tag[] getControllerTags() {
		return null;
	}

}
