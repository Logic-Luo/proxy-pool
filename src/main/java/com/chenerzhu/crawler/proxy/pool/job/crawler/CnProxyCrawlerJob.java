package com.chenerzhu.crawler.proxy.pool.job.crawler;

import com.chenerzhu.crawler.proxy.pool.entity.ProxyIp;
import com.chenerzhu.crawler.proxy.pool.entity.WebPage;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * https://www.cn-proxy.com/
 *
 * @author logic
 * @date 2019/7/13 3:28 PM
 * @since 1.0
 */
@Slf4j
public class CnProxyCrawlerJob extends AbstractCrawler {

    public CnProxyCrawlerJob(ConcurrentLinkedQueue<ProxyIp> proxyIpQueue, String pageUrl) {
        super(proxyIpQueue, pageUrl);
    }

    @Override
    public void parsePage(WebPage webPage) {
        long startTime = System.currentTimeMillis();
        int count = 0;

        Document document = webPage.getDocument();
        Elements elements = document.body().getElementsByTag("tr");
        for (int i = 1; i < elements.size(); i++) {
            Element element = null;
            try {
                element = elements.get(i);
                String ip = element.child(0).text().trim();
                String port = element.child(1).text().trim();
                char start = ip.charAt(0);
                if (start < '0' || start > '9') {
                    continue;
                }

                count ++;

                ProxyIp proxyIp = new ProxyIp();
                proxyIp.setIp(ip);
                proxyIp.setPort(Integer.parseInt(port));
                proxyIp.setLocation(element.child(3).text());
                proxyIp.setType("http");
                proxyIp.setAvailable(true);
                proxyIp.setCreateTime(new Date());
                proxyIp.setLastValidateTime(new Date());
                proxyIp.setValidateCount(0);

                proxyIpQueue.offer(proxyIp);
            } catch (NumberFormatException e) {
                log.error("解析url={}, element={} 异常", pageUrl, element == null ? "" : element.text(), e);
            } finally {
                log.info("解析 https://cn-proxy.com/ 完成，花费时间={}, 抓取个数={}", System.currentTimeMillis() - startTime, count);
            }
        }
    }
}
