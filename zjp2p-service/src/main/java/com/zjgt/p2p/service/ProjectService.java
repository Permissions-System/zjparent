package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Project;
import com.zjgt.util.Page;
import java.util.List;
import java.util.Map;

public abstract interface ProjectService
{
  public abstract int addProject(Project paramProject);

  public abstract int updateProject(Project paramProject);

  public abstract int deleteProject(Long paramLong);

  public abstract Project findProjectByProjectId(Long paramLong);

  public abstract Project getProjectByProjectcode(String paramString);

  public abstract Page<Project> getProjectsByPage(Map<String, String> paramMap);

  public abstract List<Project> selectAll();

  public abstract List<Project> getProjectByInstcode(String paramString);
}