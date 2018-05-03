package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Translogplat;
import com.zjgt.util.Page;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface TranslogplatService
{
  public abstract Page<Translogplat> getTranslogplatByPage(Map<String, String> paramMap)
    throws BusinessException;
}