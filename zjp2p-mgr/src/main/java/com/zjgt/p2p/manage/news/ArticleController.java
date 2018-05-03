package com.zjgt.p2p.manage.news;


import java.io.File;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.Page;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.StringUtil;
import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.service.ArticleService;
import com.zjgt.p2p.service.ArticlecategoryService;

/**
 * @FileName:ArticleController.java
 * @Function:TODO
 * @date:2014年12月19日 下午4:24:28
 * @author zhouyi
 * @since jdk1.6
 */
@Controller
@RequestMapping(value="/news")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticlecategoryService articlecategoryService;
	
	

	@RequestMapping(value="saveNews")
	public String saveArticle(@ModelAttribute("article") Article article,String create,Model model,HttpServletRequest request,
				@RequestParam(value = "imageFile", required = false) MultipartFile file) {
        String path = request.getSession().getServletContext().getRealPath("static/upload");  
        String fileName = file.getOriginalFilename();  
        if(StringUtil.isNotEmpty(fileName)){
	        File targetFile = new File(path, fileName);
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	       String fileUrl=request.getContextPath()+"/static/upload/"+fileName;
	       try {
			article.setThumbnail(PropertiesUtils.getProperties("zjp2p-managerURL")+fileUrl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.println("id================="+article.getId());
    	if(StringUtil.isEmpty(create)){
    		article.setCreateDate(new Date());
    	}else{
    		try {
    			article.setCreateDate(DateConverterUtil.parseDate(create));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        article.setModifyDate(new Date()); 
        if(article.getId()==null){
        	articleService.addArticle(article);
        }else{ 
			articleService.updateArticle(article);
        }

		return "redirect:/news/queryNewsList.do";
	}
	
	
	@RequestMapping(value="deleteNews")
	public String deleteArticle(Model model,String id) {
		articleService.deleteByPrimaryKey(Long.valueOf(id));
		return "redirect:/news/queryNewsList.do";
	}
	
	
	@RequestMapping(value="editNews")
	public String editArticle(Model model,String id) {
		List<Articlecategory>  articlecategoryList=articlecategoryService.getArticlecategoryByType(2L);
		if(StringUtil.isNotEmpty(id)){
			Article article=articleService.getArticle(Long.valueOf(id));
			model.addAttribute("article", article);
		}
		model.addAttribute("articlecategoryList", articlecategoryList);
		return "news/editNews";
	}

	@RequestMapping(value="viewNews")
	public String getArticle(Model model,String id) {
		List<Articlecategory>  articlecategoryList=articlecategoryService.getArticlecategoryByType(2L);
			Article article=articleService.getArticle(Long.valueOf(id));
			model.addAttribute("article", article);
		model.addAttribute("articlecategoryList", articlecategoryList);
		return "news/viewNews";
	}
	
	@RequestMapping(value="queryNewsList")
	public String queryNewsList(Model model,String title,String beginTime,String endTime,String pageNow){
		List<Articlecategory>  articlecategoryList=articlecategoryService.getArticlecategoryByType(2L);
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
		return "news/news_manager";
	}
}
