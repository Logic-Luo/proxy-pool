package com.chenerzhu.crawler.proxy.pool;

import com.chenerzhu.crawler.proxy.pool.job.crawler.ProxynovaCrawlerJob;
import org.junit.Test;

/**
 * @author logic
 * @date 2019/7/12 11:59 AM
 * @since 1.0
 */
public class TestNewProxy {
    @Test
    public void proxyTest() {
        new ProxynovaCrawlerJob(null, "https://www.proxynova.com/proxy-server-list/").run();
    }
}
