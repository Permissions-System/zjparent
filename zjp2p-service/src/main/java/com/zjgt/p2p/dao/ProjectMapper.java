package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Project;
import com.zjgt.p2p.model.ProjectExample;
import java.util.List;

public abstract interface ProjectMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Project paramProject);

  public abstract int insertSelective(Project paramProject);

  public abstract List<Project> selectByExample(ProjectExample paramProjectExample);

  public abstract Project selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Project paramProject);

  public abstract int updateByPrimaryKey(Project paramProject);

  public abstract List<Project> selectByExampleLimit(ProjectExample paramProjectExample);

  public abstract int getProjectCount(ProjectExample paramProjectExample);
}