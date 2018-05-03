/**
 * 软件著作权：百富金融技术部
 * 项目名称：互联网金融样例项目
 */
package com.zjgt.p2p.manage.common;

import javax.security.auth.DestroyFailedException;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.cacheframework.cache.ICacheClient;


/**
 * CacheManager for shiro
 * 
 * @author hukaijian
 */

public class MemcachedManagerForShiro implements  CacheManager,Destroyable {
	private static Logger logger = LoggerFactory
			.getLogger("MemcachedManagerForShiro.class");
	@SuppressWarnings("rawtypes")
	private MemcachedClientForShiro mcfs;
	private String group;
	private ICacheClient cacheClient;
	
	public MemcachedManagerForShiro() {
	}

	public void setCacheClient(ICacheClient cacheClient) {
		this.cacheClient = cacheClient;
	}

	@Override
	public void destroy() throws DestroyFailedException {
		mcfs = null;
		group = null;
		cacheClient= null;
	}

	@SuppressWarnings("rawtypes")
	public void setMcfs(MemcachedClientForShiro mcfs) {
		this.mcfs = mcfs;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		if(mcfs == null) {
			mcfs = new MemcachedClientForShiro<String, Object>(group, cacheClient);
		}
		return this.mcfs;
	}
}
