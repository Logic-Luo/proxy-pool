package com.chenerzhu.crawler.proxy.pool.job.crawler;

import com.chenerzhu.crawler.proxy.pool.entity.ProxyIp;
import com.chenerzhu.crawler.proxy.pool.entity.WebPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * https://www.rmccurdy.com/scripts/proxy/good.txt
 *
 * @author logic
 * @date 2019/7/13 6:07 PM
 * @since 1.0
 */
@Slf4j
public class RmccurdyCrawlerJob extends AbstractCrawler {
    public RmccurdyCrawlerJob(ConcurrentLinkedQueue<ProxyIp> proxyIpQueue, String pageUrl) {
        super(proxyIpQueue, pageUrl);
    }

    @Override
    public void parsePage(WebPage webPage) {
        String page = webPage.getPage();
        if (StringUtils.isEmpty(page)) {
            return;
        }

        String[] arrays = page.split("\n");

        if (arrays == null || arrays.length == 0) {
            return;
        }

        int length = arrays.length;

        for (int i = 0; i < length - 1; i ++) {
            arrays[i] = arrays[i].replace("\r", "");
            try {
                String[] ipPort = arrays[i].split(":");
                if (ipPort == null || ipPort.length == 0) {
                    continue;
                }

                ProxyIp proxyIp = new ProxyIp();
                proxyIp.setIp(ipPort[0]);
                proxyIp.setPort(Integer.parseInt(ipPort[1]));
                proxyIp.setLocation("");
                proxyIp.setType("http");
                proxyIp.setAvailable(true);
                proxyIp.setCreateTime(new Date());
                proxyIp.setLastValidateTime(new Date());
                proxyIp.setValidateCount(0);

                proxyIpQueue.offer(proxyIp);
            } catch (Exception e) {
                log.error("解析数据异常：data={}", arrays[i], e);
            }
        }

    }
}
