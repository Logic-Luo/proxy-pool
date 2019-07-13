package com.chenerzhu.crawler.proxy.pool.job.crawler;

import org.junit.Test;

import static org.junit.Assert.*;

public class RmccurdyCrawlerJobTest {

    @Test
    public void parsePage() {
        new RmccurdyCrawlerJob(null, "https://www.rmccurdy.com/scripts/proxy/good.txt").run();
    }
}