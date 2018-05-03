package com.zjgt.p2p.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.service.ArticleService;
import com.zjgt.p2p.service.ArticlecategoryService;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;

@Controller
public class ArticleController
{
  Logger logger;

  @Autowired
  private ArticleService articleService;

  @Autowired
  private ArticlecategoryService articlecategoryService;

  public ArticleController()
  {
    this.logger = LoggerFactory.getLogger(ArticleController.class);
  }

  @RequestMapping({"queryNewsAll"})
  public String getNewsAll(Model model, String pageNow, String categoryid)
    throws Exception
  {
    Map<String, Object> map = new HashMap<String, Object>();
    List<String> timeList = new ArrayList<String>();
    List<Long> categoryidList = new ArrayList<Long>();
    if ((StringUtil.isEmpty(categoryid)) || (!("22".equalsIgnoreCase(categoryid)))) {
      categoryid = "21";
      categoryidList.add(Long.valueOf(21L));
    } else {
      categoryidList.add(Long.valueOf(22L));
    }
    map.put("pageNow", pageNow);
    map.put("categoryidList", categoryidList);
    map.put("categoryid", categoryid);
    Page<Article> page = this.articleService.getArticleByPage(map);
    List<Article> newsList = page.getResults();
    if (!(newsList.isEmpty())) {
      for (Article news : newsList) {
        findNewsSumary(news);
        String time = DateConverterUtil.formatDatetime(news.getCreateDate(), "yyyy-MM");
        timeList.add(time);
      }
    }
    page.setResults(newsList);
    model.addAttribute("map", map);
    model.addAttribute("page", page);
    model.addAttribute("timeList", timeList);
    return "information/news";
  }

  private void findNewsSumary(Article news) throws Exception {
    if (news.getContent() != null) {
      StringBuilder sb = new StringBuilder();
      String summary = news.getContent().trim();
      summary = StringUtil.dislodgeImage(summary);
      if (summary.length() > 30) {
        summary = summary.substring(0, 30);
        summary = new StringBuilder().append(summary).append("...").toString();
      }
      news.setContent(sb.append(summary).toString());
    }
  }

  @RequestMapping({"queryNewsOne"})
  public String getNewsOne(Model model, String id)
    throws Exception
  {
    Article article = this.articleService.getArticle(Long.valueOf(id));
    if (article != null) {
      Articlecategory articlecategory = this.articlecategoryService.findArticlecategoryById(article.getCategoryid());
      StringBuilder title = new StringBuilder();
      title.append(article.getTitle());
      int length = title.length();
      if (length <= 10) {
        title.append("<br><br><br>");
      }
      if ((length > 10) && (length <= 20)) {
        title.append("<br><br>");
      }
      if ((length > 20) && (length <= 30)) {
        title.append("<br>");
      }
      model.addAttribute("news", article);
      model.addAttribute("articlecategory", articlecategory);
      model.addAttribute("title", title.toString());
      return "information/news_datail";
    }
    return "redirect:/queryNewsAll.do";
  }

  @RequestMapping({"introduce"})
  public String getIntroduce(Model model)
    throws Exception
  {
    Map map = new HashMap();
    List categoryidList = new ArrayList();
    categoryidList.add(Long.valueOf(11L));
    map.put("categoryidList", categoryidList);
    Page page = this.articleService.getArticleByPage(map);
    Article information = (Article)page.getResults().get(0);
    model.addAttribute("information", information);
    return "information/information";
  }

  @RequestMapping({"team"})
  public String getEliteTeam(Model model)
    throws Exception
  {
    Map map = new HashMap();
    List categoryidList = new ArrayList();
    categoryidList.add(Long.valueOf(12L));
    map.put("categoryidList", categoryidList);
    Page page = this.articleService.getArticleByPage(map);
    Article information = (Article)page.getResults().get(0);
    model.addAttribute("information", information);
    return "information/information_2";
  }

  @RequestMapping({"investor"})
  public String getInvestor(Model model)
    throws Exception
  {
    Map map = new HashMap();
    List categoryidList = new ArrayList();
    categoryidList.add(Long.valueOf(13L));
    map.put("categoryidList", categoryidList);
    Page page = this.articleService.getArticleByPage(map);
    Article information = (Article)page.getResults().get(0);
    model.addAttribute("information", information);
    return "information/investor";
  }

  @RequestMapping({"policy"})
  public String getPolicy(Model model)
    throws Exception
  {
    Map map = new HashMap();
    List categoryidList = new ArrayList();
    categoryidList.add(Long.valueOf(14L));
    map.put("categoryidList", categoryidList);
    Page page = this.articleService.getArticleByPage(map);
    Article information = (Article)page.getResults().get(0);
    model.addAttribute("information", information);
    return "information/policy";
  }

  @RequestMapping({"queryDeptAll"})
  public String getDeptAll(Model model, String parent) throws Exception {
    List articlecategoryList = this.articlecategoryService.getArticlecategoryByType(Long.valueOf(3L));
    model.addAttribute("articlecategoryList", articlecategoryList);
    return "information/joinus";
  }

  @RequestMapping(value={"queryArticle"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Page<Article> queryArticle(Model model, String categoryid) throws Exception
  {
    Map map = new HashMap();
    List categoryidList = new ArrayList();
    categoryidList.add(Long.valueOf(Long.parseLong(categoryid)));
    map.put("categoryidList", categoryidList);
    Page page = this.articleService.getArticleByPage(map);
    return page;
  }
}