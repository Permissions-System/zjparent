package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.ProjectStatus;
import com.zjgt.p2p.dao.ProjectMapper;
import com.zjgt.p2p.model.Project;
import com.zjgt.p2p.model.ProjectExample;
import com.zjgt.p2p.model.ProjectExample.Criteria;
import com.zjgt.p2p.service.ProjectService;
import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("projectService")
public class ProjectServiceImpl
  implements ProjectService
{
  private static final String PATTERN = "yyyy-MM-dd";

  @Autowired
  private ProjectMapper dao;

  public int addProject(Project project)
  {
    int a = 0;
    try {
      a = this.dao.insert(project);
    } catch (Exception e) {
      a = 0;
      e.printStackTrace();
    }
    return a;
  }

  @Transactional
  public int updateProject(Project project) {
    int a = 0;
    try {
      a = this.dao.updateByPrimaryKey(project);
    } catch (Exception e) {
      a = 0;
      e.printStackTrace();
    }
    return a;
  }

  public Project findProjectByProjectId(Long id)
  {
    ProjectExample example = new ProjectExample();
    example.createCriteria().andIdEqualTo(id);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Project)list.get(0));
    }
    return null;
  }

  public Page<Project> getProjectsByPage(Map<String, String> map)
  {
    Page pages = null;

    List projectList = null;
    ProjectExample exam = new ProjectExample();
    ProjectExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);
      if (("projectcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andProjectcodeEqualTo(value);
      }

      if (("projectname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andProjectnameEqualTo(value);
      }

      if (("instname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andInstnameEqualTo(value);
      }

      if (("instcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andInstcodeEqualTo(value);
      }

      if (("repaymentway".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andPaywayEqualTo(Integer.valueOf(value));
      }

      if (("status".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andStatusEqualTo(Integer.valueOf(value));
      }

      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andOpdateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));

          System.out.println("==============" + new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andOpdateLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }
    exam.setOrderByClause("opDate DESC ");
    int totalCount = this.dao.getProjectCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new Page(totalCount, pageNow);

    pages.setPageSize(Const.NEWS_PAGE_SIZE);
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Const.NEWS_PAGE_SIZE));

    projectList = this.dao.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(projectList);
    return pages;
  }

  public int deleteProject(Long id)
  {
    return this.dao.deleteByPrimaryKey(id);
  }

  public List<Project> selectAll()
  {
    ProjectExample example = new ProjectExample();
    example.createCriteria().andStatusNotEqualTo(Integer.valueOf(ProjectStatus.FORZEN.getKey()));
    this.dao.selectByExample(example);
    return this.dao.selectByExample(example);
  }

  public List<Project> getProjectByInstcode(String instcode)
  {
    List projectList = null;
    ProjectExample example = new ProjectExample();
    example.createCriteria().andInstcodeEqualTo(instcode);
    projectList = this.dao.selectByExample(example);
    return projectList;
  }

  public Project getProjectByProjectcode(String projectcode)
  {
    ProjectExample example = new ProjectExample();
    example.createCriteria().andProjectcodeEqualTo(projectcode);
    List projectList = this.dao.selectByExample(example);
    if ((projectList != null) && (!(projectList.isEmpty()))) {
      return ((Project)projectList.get(0));
    }
    return null;
  }
}