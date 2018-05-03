package com.zjgt.p2p.article.model;

public class ArticletagKey {
    /**
     * 字段名称: 文章编号 .
     * 字段定义: articletag.articles
     *
     * @ET
     */
    private Long articles;

    /**
     * 字段名称: tag .
     * 字段定义: articletag.tags
     *
     * @ET
     */
    private Long tags;

    /**
     * This method:getArticles
     * articletag.articles
     *
     * @return the value of articletag.articles
     *
     * @ET
     */
    public Long getArticles() {
        return articles;
    }

    /**
     * This method:setArticles
     *  articletag.articles
     *
     * @param articles the value for articletag.articles
     *
     * @ET
     */
    public void setArticles(Long articles) {
        this.articles = articles;
    }

    /**
     * This method:getTags
     * articletag.tags
     *
     * @return the value of articletag.tags
     *
     * @ET
     */
    public Long getTags() {
        return tags;
    }

    /**
     * This method:setTags
     *  articletag.tags
     *
     * @param tags the value for articletag.tags
     *
     * @ET
     */
    public void setTags(Long tags) {
        this.tags = tags;
    }
}