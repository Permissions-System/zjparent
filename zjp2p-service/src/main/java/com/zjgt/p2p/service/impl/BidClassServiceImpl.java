package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.BidclassMapper;
import com.zjgt.p2p.model.Bidclass;
import com.zjgt.p2p.service.BidClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bidClassService")
public class BidClassServiceImpl
  implements BidClassService
{

  @Autowired
  private BidclassMapper bidclassMapper;

  public Bidclass selectByPrimaryKey(Long id)
  {
    return this.bidclassMapper.selectByPrimaryKey(id);
  }
}