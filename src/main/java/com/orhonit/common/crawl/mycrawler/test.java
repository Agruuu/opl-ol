package com.orhonit.common.crawl.mycrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.orhonit.common.crawl.link.Links;
import com.orhonit.common.crawl.page.Page;
import com.orhonit.common.crawl.page.PageParserTool;
import com.orhonit.common.crawl.page.RequestAndResponseTool;

public class test {

    /**
     * 使用种子初始化 URL 队列
     *
     * @param seeds 种子 URL
     * @return
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++){
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }
    
    public static Set<String> getURlList(String url){
    	  //根据URL得到page;
        Page page = RequestAndResponseTool.sendRequstAndGetResponse(url);

        Set<String> links = PageParserTool.getLinks(page,"ul[class=list_ul02] a");
        //ArrayList<String> links = PageParserTool.getAttrs(page, "ul[class=list_ul02] a","abs:href");
        for (String link : links) {
            Links.addUnvisitedUrlQueue(link);
            System.out.println("新增爬取路径: " + link);
        }
        return links;
    }
    
    /**
     * 抓取过程
     *
     * @param seeds
     * @return 
     * @return
     */
    public static void crawling(Set<String> seeds) {
    	   	List<String> rt = new ArrayList();
    		for(String a :seeds) {
    			 Page page = RequestAndResponseTool.sendRequstAndGetResponse(a);

                 //对page进行处理： 访问DOM的某个标签
                 //Elements es = PageParserTool.select(page,"div[class=wzxxl_q] h3");
                 //Elements es = PageParserTool.select(page,"p[class=sm_q] a");
    			 Elements es = PageParserTool.select(page,"div[class=zwnr_q] p");
    			 List<Element> childElements = es;
                 if(!es.isEmpty()){
                	 for(Element child : childElements) {
                		 List<Element> elementList = child.getAllElements();
                         for (Element ele : elementList) {
                             //System.out.println(ele.nodeName() + ": " + ele.text());
                        	 if(ele.nodeName().equals("p")) {
                        		 rt.add(ele.nodeName() + ": " + ele.text());
                             }
                        	 }
                        	
                	 }
                	 
                
                     //System.out.println(es);
                 }
    		}
    		for(String a:rt) {
    			System.err.println(a);
    		}
    		
    } 
    
//    public static void main(String[] args) {  	
//    	crawling(getURlList("http://www.ordosnews.com/news/node_102.htm"));
//    	
//	}
}
