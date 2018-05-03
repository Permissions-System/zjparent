package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.PlatformAssetMapper;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.PlatformAssetExample;
import com.zjgt.p2p.service.PlatformAssetService;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("platformAssetService")
public class PlatformAssetServiceImpl
  implements PlatformAssetService
{

  @Autowired
  private PlatformAssetMapper pltassetdao;

  public PlatformAsset findAsset()
    throws BusinessException
  {
    PlatformAssetExample example = new PlatformAssetExample();

    List list = this.pltassetdao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((PlatformAsset)list.get(0));
    }
    return null;
  }

  public int save(PlatformAsset acct) throws BusinessException
  {
    int a = 0;
    if ((acct != null) && (acct.getId() != null))
      a = this.pltassetdao.updateByPrimaryKeySelective(acct);
    else {
      a = this.pltassetdao.insertSelective(acct);
    }
    return a;
  }
}