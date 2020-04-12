package com.orhonit.common.crawl.mycrawler;

import org.jsoup.select.Elements;

import com.orhonit.common.crawl.link.LinkFilter;
import com.orhonit.common.crawl.link.Links;
import com.orhonit.common.crawl.page.Page;
import com.orhonit.common.crawl.page.PageParserTool;
import com.orhonit.common.crawl.page.RequestAndResponseTool;
import com.orhonit.common.crawl.util.FileTool;

import java.util.ArrayList;
import java.util.Set;

public class MyCrawler {

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


    /**
     * 抓取过程
     *
     * @param seeds
     * @return 
     * @return
     */
    public void crawling(String[] seeds) {

        //初始化 URL 队列
       //initCrawlerWithSeeds(seeds);

        //定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.ordosnews.com"))
                    return true;
                else
                    return false;
            }
        };

        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty()  && Links.getVisitedUrlNum() <= 1000) {

            //先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null){
                continue;
            }

            //根据URL得到page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);

            //对page进行处理： 访问DOM的某个标签
            Elements es = PageParserTool.select(page,"div[class=wzxxl_q] h3");
            if(!es.isEmpty()){
                System.out.println("下面将打印所有h3标签： ");
                System.out.println(es);
            }

            //将保存文件
            //FileTool.saveToLocal(page);

            //将已经访问过的链接放入已访问的链接中；
            Links.addVisitedUrlSet(visitUrl);

            //得到超链接
            Set<String> links = PageParserTool.getLinks(page,"ul[class=list_ul02] a");
            //ArrayList<String> links = PageParserTool.getAttrs(page, "ul[class=list_ul02] a","abs:href");
            for (String link : links) {
                Links.addUnvisitedUrlQueue(link);
                System.out.println("新增爬取路径: " + link);
            }
//            initCrawlerWithSeeds((String[])links.toArray());
//            Elements es2 = PageParserTool.select(page,"div[class=wzxxl_q] h3");
//                //Links.addUnvisitedUrlQueue(link);
//                System.out.println("新闻标题: " + es2);
//           return links;
        }
//        return null;

    }
    
    

    //main 方法入口
//    public static void main(String[] args) {
//        MyCrawler crawler = new MyCrawler();
//       for(String a:crawler.crawling(new String[]{"http://www.ordosnews.com/news/node_102.htm"})) {
//    	   crawler.crawling(new String[]{a});
//       }
//    }
}
