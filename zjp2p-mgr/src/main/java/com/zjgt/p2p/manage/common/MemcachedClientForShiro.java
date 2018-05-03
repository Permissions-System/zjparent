/**
 * 软件著作权：百富金融技术部
 * 项目名称：互联网金融样例项目
 */
package com.zjgt.p2p.manage.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springfk.pancloud.cacheframework.cache.ICacheClient;

@SuppressWarnings("hiding")
public class MemcachedClientForShiro<String, Object> implements Cache<String, Object>{
	private static   Logger logger = LoggerFactory.getLogger("MemcachedClientForShiro.class");
	
	private ICacheClient cacheClient;
	private java.lang.String group;
	
	public MemcachedClientForShiro(java.lang.String group,ICacheClient cacheClient){
		this.group = group;
		this.cacheClient = cacheClient;
	}

	public void setCacheClient(ICacheClient cacheClient) {
		this.cacheClient = cacheClient;
	}

	public void setGroup(java.lang.String group) {
		this.group = group;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object get(String key) throws CacheException {
		return (Object) cacheClient.get(group, key.toString());
	}

	@Override
	public Object put(String key, Object value) throws CacheException {
		if(cacheClient.put(group, key.toString(), value)) {
			return value;
		}else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object remove(String key) throws CacheException {
		if(cacheClient.remove(group, key.toString())) {
			return (Object) key;
		}else {
			return null;
		}
	}

	@Override
	public void clear() throws CacheException {
		cacheClient.clear(group);
	}

	@Override
	public int size() {	
		return cacheClient.size(group);
	}

	@Override
    public Set<String> keys() {
        try {
        	//TODO: unsupported
        	return Collections.emptySet();
        } catch (Exception e) {
        	logger.error("get values error"+e.toString());
        	return null;
        }
    }

	@Override
    public Collection<Object> values() {
        try {
            //TODO: unsupported
            return Collections.emptyList();
        } catch (Exception e){
        	logger.error("get values error"+e.toString());
        	return null;
        }
    }
}
