// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) lnc 
// Source File Name:   AgreementService.java

package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Agreement;
import java.util.List;

public interface AgreementService
{

    public abstract void save(Agreement agreement);

    public abstract Agreement getByNo(String s);

    public abstract Agreement get(Integer integer);

    public abstract List getAll();
}
