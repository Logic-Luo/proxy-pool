package com.chenerzhu.crawler.proxy.pool.job.crawler;

import org.junit.Test;


public class CnProxyCrawlerJobTest {
    @Test
    public void testRun() {
        new CnProxyCrawlerJob(null, "https://cn-proxy.com/").run();
    }

}