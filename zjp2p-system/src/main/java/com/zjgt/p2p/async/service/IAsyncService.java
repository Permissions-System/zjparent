package com.zjgt.p2p.async.service;

import org.springfk.pancloud.exception.BusinessException;

public abstract interface IAsyncService
{
  public abstract void addAsyncTask(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, int paramInt)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject1, String paramString1, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, Object paramObject2, String paramString2)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject1, String paramString1, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject, Object paramObject2, String paramString2, int paramInt)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject, String paramString, Object[] paramArrayOfObject, int paramInt)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject1, String paramString1, Object[] paramArrayOfObject, Object paramObject2, String paramString2)
    throws BusinessException;

  public abstract void addAsyncTask(Object paramObject1, String paramString1, Object[] paramArrayOfObject, Object paramObject2, String paramString2, int paramInt)
    throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.async.service.IAsyncService
 * JD-Core Version:    0.5.3
 */