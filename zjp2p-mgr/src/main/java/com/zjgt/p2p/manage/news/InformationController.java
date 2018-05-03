package com.zjgt.p2p.manage.news;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.service.ArticleService;
import com.zjgt.p2p.service.ArticlecategoryService;
import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;

/**
 * @FileName:ArticleController.java
 * @Function:TODO
 * @date:2014年12月19日 下午4:24:28
 * @author zhouyi
 * @since jdk1.6
 */
@Controller
@RequestMapping(value="/news")
public class InformationController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticlecategoryService articlecategoryService;
	
	

	@RequestMapping(value="saveInformation")
	public String saveArticle(@ModelAttribute("article") Article article,Model model,HttpServletRequest request) {
 
        System.out.println("id================="+article.getId());
        if(article.getId()==null){
        	article.setCreateDate(new Date());
        	articleService.addArticle(article);
        }else{
	        article.setModifyDate(new Date());
			articleService.updateArticle(article);
        }

		return "redirect:/news/queryInformationList.do";
	}
	
	
	@RequestMapping(value="deleteInformation")
	public String deleteArticle(Model model,String id) {
		articleService.deleteByPrimaryKey(Long.valueOf(id));
		return "redirect:/news/queryInformationList.do";
	}
	
	
	@RequestMapping(value="editInformation")
	public String editArticle(Model model,String id) {
		List<Articlecategory>  articlecategoryList=articlecategoryService.getArticlecategoryByType(1L);
		if(StringUtil.isNotEmpty(id)){
			Article article=articleService.getArticle(Long.valueOf(id));
			model.addAttribute("article", article);
		}
		model.addAttribute("articlecategoryList", articlecategoryList);
		return "news/editInformation";
	}

	@RequestMapping(value="viewInformation")
	public String getArticle(Model model,String id) {
		List<Articlecategory>  articlecategoryList=articlecategoryService.getArticlecategoryByType(1L);
			Article article=articleService.getArticle(Long.valueOf(id));
			model.addAttribute("article", article);
		model.addAttribute("articlecategoryList", articlecategoryList);
		return "news/viewInformation";
	}
	
	@RequestMapping(value="queryInformationList")
	public String queryRecruitList(Model model,String title,String beginTime,String endTime,String pageNow){
		List<Articlecategory>  articlecategoryList=articlecategoryService.getArticlecategoryByType(1L);
		Map<String ,Object> map=new HashMap<String, Object>();
		List<Long> categoryidList=new ArrayList<Long>();
		for(Articlecategory articlecategory:articlecategoryList){
			categoryidList.add(articlecategory.getId());
		}
		map.put("pageNow", pageNow);
		map.put("categoryidList", categoryidList);
		map.put("title", title);
		map.put("beginTime", beginTime);
		map.put("endTime", endTime);
		map.put("pageSize", "6");
		Page<Article> page=articleService.getArticleByPage(map);
		model.addAttribute("map",map);
		model.addAttribute("page",page);
		model.addAttribute("articlecategoryList", articlecategoryList);
		return "news/information_manager";
	}
}
