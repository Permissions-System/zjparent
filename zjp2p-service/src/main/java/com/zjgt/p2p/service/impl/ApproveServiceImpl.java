package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.ApproveMapper;
import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.ApproveExample;
import com.zjgt.p2p.service.ApproveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("approveService")
public class ApproveServiceImpl
  implements ApproveService
{

  @Autowired
  private ApproveMapper approveMapper;

  public Approve selectByPrimaryKey(Long id)
  {
    return this.approveMapper.selectByPrimaryKey(id);
  }

  public List<Approve> selectByExample(ApproveExample example)
  {
    return this.approveMapper.selectByExample(example);
  }

  public int addOrder(Approve approve)
  {
    return this.approveMapper.insert(approve);
  }
}