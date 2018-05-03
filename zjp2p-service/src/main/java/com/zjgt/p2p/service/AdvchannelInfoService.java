// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) lnc 
// Source File Name:   AdvchannelInfoService.java

package com.zjgt.p2p.service;

import com.zjgt.p2p.model.AdvchannelInfo;
import org.springfk.pancloud.exception.BusinessException;

public interface AdvchannelInfoService
{

    public abstract void insert(AdvchannelInfo advchannelinfo)
        throws BusinessException;

    public abstract AdvchannelInfo findInfo(String s)
        throws BusinessException;
}
