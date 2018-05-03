package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.AdvchannelInfoMapper;
import com.zjgt.p2p.model.AdvchannelInfo;
import com.zjgt.p2p.model.AdvchannelInfoExample;
import com.zjgt.p2p.model.AdvchannelInfoExample.Criteria;
import com.zjgt.p2p.service.AdvchannelInfoService;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("advchannelInfoService")
public class AdvchannelInfoServiceImpl
  implements AdvchannelInfoService
{

  @Autowired
  private AdvchannelInfoMapper dao;

  public void insert(AdvchannelInfo info)
    throws BusinessException
  {
    this.dao.insert(info);
  }

  public AdvchannelInfo findInfo(String channel)
    throws BusinessException
  {
    AdvchannelInfoExample example = new AdvchannelInfoExample();
    example.createCriteria().andChannelcodeEqualTo(channel);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((AdvchannelInfo)list.get(0));
    }
    return null;
  }
}