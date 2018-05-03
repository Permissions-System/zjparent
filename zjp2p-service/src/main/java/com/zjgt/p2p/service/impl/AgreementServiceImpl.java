package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.AgreementMapper;
import com.zjgt.p2p.model.Agreement;
import com.zjgt.p2p.model.AgreementExample;
import com.zjgt.p2p.model.AgreementExample.Criteria;
import com.zjgt.p2p.service.AgreementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementServiceImpl
  implements AgreementService
{

  @Autowired
  private AgreementMapper mapper;

  public void save(Agreement record)
  {
    if (record.getId() == null)
      this.mapper.insertSelective(record);
    else
      this.mapper.updateByPrimaryKeySelective(record);
  }

  public Agreement getByNo(String agreementNo)
  {
    AgreementExample example = new AgreementExample();
    example.createCriteria().andAgreementnoEqualTo(agreementNo);
    List agreementList = this.mapper.selectByExample(example);
    if ((agreementList != null) && (!(agreementList.isEmpty()))) {
      return ((Agreement)agreementList.get(0));
    }
    return null;
  }

  public Agreement get(Integer id)
  {
    return this.mapper.selectByPrimaryKey(id);
  }

  public List<Agreement> getAll()
  {
    return this.mapper.selectByExample(new AgreementExample());
  }
}