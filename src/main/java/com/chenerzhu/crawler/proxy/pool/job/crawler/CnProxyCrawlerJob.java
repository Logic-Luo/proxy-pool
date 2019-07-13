package com.chenerzhu.crawler.proxy.pool.job.crawler;

import com.chenerzhu.crawler.proxy.pool.entity.ProxyIp;
import com.chenerzhu.crawler.proxy.pool.entity.WebPage;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * https://cn-proxy.com/
 *
 * @author logic
 * @date 2019/7/13 3:28 PM
 * @since 1.0
 */
@Slf4j
public class CnProxyCrawlerJob extends AbstractCrawler {
    private static String content = "<!DOCTYPE html>\n" +
            "<html lang=\"zh-CN\" prefix=\"og: http://ogp.me/ns#\">\n" +
            "\n" +
            " <body class=\"home page page-id-4 page-template-default\"> \n" +
            "  <div id=\"wrapper\"> \n" +
            "   <div id=\"header\"> \n" +
            "    <div id=\"masthead\"> \n" +
            "     <h1 id=\"logo\"> <a href=\"https://cn-proxy.com/\" title=\"中国ip地址 | 中国代理服务器\" rel=\"home\"><img src=\"https://cn-proxy.com/wp-content/themes/piol/images/logo.png\" alt=\"中国ip地址 | 中国代理服务器\" /></a> </h1> \n" +
            "     <div id=\"rss\"> \n" +
            "      <a href=\"http://cn-proxy.com/feed\" target=\"_blank\"><img src=\"https://cn-proxy.com/wp-content/themes/piol/images/rss.png\" alt=\"订阅本站RSS\" /></a> \n" +
            "     </div> \n" +
            "     <div id=\"menu\"> \n" +
            "      <div class=\"menu-%e5%af%bc%e8%88%aa-container\">\n" +
            "       <ul id=\"menu-%e5%af%bc%e8%88%aa\" class=\"menu\">\n" +
            "        <li id=\"menu-item-58\" class=\"menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-4 current_page_item menu-item-58\"><a href=\"https://cn-proxy.com/\">最新中国ip地址代理服务器</a></li> \n" +
            "        <li id=\"menu-item-59\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-59\"><a href=\"https://cn-proxy.com/archives/category/howto\">代理服务器设置教程</a> \n" +
            "         <ul class=\"sub-menu\"> \n" +
            "          <li id=\"menu-item-182\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-182\"><a href=\"https://cn-proxy.com/archives/category/hot-videos\">热门剧观看指南</a></li> \n" +
            "         </ul> </li> \n" +
            "        <li id=\"menu-item-279\" class=\"menu-item menu-item-type-taxonomy menu-item-object-category menu-item-279\"><a href=\"https://cn-proxy.com/archives/category/%e5%ae%9e%e7%94%a8%e5%b7%a5%e5%85%b7\">实用工具</a></li> \n" +
            "        <li id=\"menu-item-171\" class=\"menu-item menu-item-type-post_type menu-item-object-forum menu-item-171\"><a href=\"https://cn-proxy.com/讨论区/forum/%e6%9c%ac%e7%ab%99%e8%ae%a8%e8%ae%ba%e5%92%8c%e7%95%99%e8%a8%80\">本站讨论和留言</a></li> \n" +
            "       </ul>\n" +
            "      </div> \n" +
            "      <a href=\"http://t.qq.com/cn-proxy\" title=\"我的腾讯微博\" target=\"_blank\" id=\"mblog\" class=\"qq\">腾讯微博</a> \n" +
            "      <form method=\"get\" id=\"searchform\" action=\"https://cn-proxy.com/\"> \n" +
            "       <div> \n" +
            "        <!--<input type=\"text\" value=\"\" name=\"s\" id=\"s\" />\n" +
            "\t\t\t\t\t\t<input type=\"submit\" id=\"searchsubmit\" value=\"搜索\" />--> \n" +
            "        <div id=\"google_translate_element\"></div>\n" +
            "        <script type=\"text/javascript\">\n" +
            "function googleTranslateElementInit() {\n" +
            "  new google.translate.TranslateElement({pageLanguage: 'zh-CN', includedLanguages: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');\n" +
            "}\n" +
            "</script>\n" +
            "        <script type=\"text/javascript\" src=\"//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit\"></script> \n" +
            "       </div> \n" +
            "      </form> \n" +
            "     </div> \n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <div id=\"main\"> \n" +
            "    <div id=\"container\"> \n" +
            "     <div class=\"col-top\"> \n" +
            "     </div> \n" +
            "     <div class=\"col-mid\"> \n" +
            "      <div id=\"post-4\" class=\"post-4 page type-page status-publish hentry\"> \n" +
            "       <h1 class=\"entry-title\">最新中国ip地址代理服务器</h1> \n" +
            "       <div class=\"entry-content\"> \n" +
            "        <!-- Quick Adsense WordPress Plugin: http://quicksense.net/ --> \n" +
            "        <div style=\"float:none;margin:10px 0 10px 0;text-align:center;\"> \n" +
            "         <script async=\"\" src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script> \n" +
            "         <!-- cn-proxy-below header --> \n" +
            "         <ins class=\"adsbygoogle\" style=\"display:block\" data-ad-client=\"ca-pub-6375232430051118\" data-ad-slot=\"2932790504\" data-ad-format=\"auto\"></ins> \n" +
            "         <script>\n" +
            "(adsbygoogle = window.adsbygoogle || []).push({});\n" +
            "</script> \n" +
            "        </div> \n" +
            "        <hr /> 如果需要全世界范围内的代理服务器，请移步\n" +
            "        <a href=\"http://cn-proxy.com/archives/218\">全球范围代理服务器</a>。\n" +
            "        <br /> 以下中国ip代理服务器地址列表由程序自动验证更新，实时更新，保证可用。\n" +
            "        <br /> 所有的代理服务器都是高度匿名，国内网站会认为您的电脑位于国内。\n" +
            "        <br /> 请定期回来\n" +
            "        <a href=\"http://cn-proxy.com\">http://cn-proxy.com</a>获取最新中国ip代理服务器。\n" +
            "        <p></p> \n" +
            "        <p><strong>需要更稳定的中国VPN，请访问<a href=\"http://vpncn.net\">http://vpncn.net</a></strong>。</p> \n" +
            "        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/style.css\" /> \n" +
            "        <script type=\"text/javascript\" src=\"js/prototype/prototype.js\"></script>\n" +
            "        <script type=\"text/javascript\" src=\"js/bramus/jsProgressBarHandler.js\"></script>\n" +
            "        <script type=\"text/javascript\" src=\"js/tablekit.js\"></script>\n" +
            "        <p></p> \n" +
            "        <div class=\"table-container\"> \n" +
            "         <table class=\"sortable\"> \n" +
            "          <thead> \n" +
            "           <tr> \n" +
            "            <th id=\"ip\" width=\"40%\">服务器地址</th> \n" +
            "            <th id=\"port\">端口</th> \n" +
            "            <th id=\"location\">位置</th> \n" +
            "            <th class=\"sortfirstdesc\" id=\"speed\">速度</th> \n" +
            "            <th id=\"lastcheck\">上次检查（北京时间）</th> \n" +
            "           </tr> \n" +
            "          </thead> \n" +
            "          <tfoot> \n" +
            "           <tr> \n" +
            "            <td>服务器地址</td> \n" +
            "            <td>端口</td> \n" +
            "            <td>位置</td> \n" +
            "            <td>速度</td> \n" +
            "            <td>上次检查</td> \n" +
            "           </tr> \n" +
            "          </tfoot> \n" +
            "          <tbody> \n" +
            "           <tr> \n" +
            "            <td>119.190.149.58</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 26%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:15</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>116.62.198.43</td> \n" +
            "            <td>8080</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 19%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:09</td> \n" +
            "           </tr> \n" +
            "          </tbody> \n" +
            "         </table> \n" +
            "        </div> \n" +
            "        <div id=\"gg_ad\"> \n" +
            "         <script async=\"\" src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" +
            "         <br /> \n" +
            "         <!-- cn-proxy代理列表中间 -->\n" +
            "         <br /> \n" +
            "         <ins class=\"adsbygoogle\" <br=\"\">\n" +
            "           style=&quot;display:inline-block;width:728px;height:90px&quot;\n" +
            "          <br /> data-ad-client=&quot;ca-pub-6375232430051118&quot;\n" +
            "          <br /> data-ad-slot=&quot;4859308901&quot;&gt;\n" +
            "         </ins>\n" +
            "         <br /> \n" +
            "         <script>\n" +
            "(adsbygoogle = window.adsbygoogle || []).push({});\n" +
            "</script> \n" +
            "        </div> \n" +
            "        <div class=\"table-container\"> \n" +
            "         <table class=\"sortable\"> \n" +
            "          <thead> \n" +
            "           <tr> \n" +
            "            <th id=\"ip\" width=\"40%\">服务器地址</th> \n" +
            "            <th id=\"port\">端口</th> \n" +
            "            <th id=\"location\">位置</th> \n" +
            "            <th class=\"sortfirstdesc\" id=\"speed\">速度</th> \n" +
            "            <th id=\"lastcheck\">上次检查（北京时间）</th> \n" +
            "           </tr> \n" +
            "          </thead> \n" +
            "          <tfoot> \n" +
            "           <tr> \n" +
            "            <td>服务器地址</td> \n" +
            "            <td>端口</td> \n" +
            "            <td>位置</td> \n" +
            "            <td>速度</td> \n" +
            "            <td>上次检查</td> \n" +
            "           </tr> \n" +
            "          </tfoot> \n" +
            "          <tbody> \n" +
            "           <tr> \n" +
            "            <td>119.41.236.180</td> \n" +
            "            <td>8010</td> \n" +
            "            <td>Hainan Haikou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 88%; background:#00dd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:20</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.111</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 82%; background:#00dd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:13</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>182.61.109.24</td> \n" +
            "            <td>8888</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 81%; background:#00dd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:06</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.77</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 80%; background:#00dd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:27</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.108</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 80%; background:#00dd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:14</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.108</td> \n" +
            "            <td>8080</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 80%; background:#00dd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:07</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.75</td> \n" +
            "            <td>8080</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 79%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:08</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>124.156.108.71</td> \n" +
            "            <td>82</td> \n" +
            "            <td>Guangxi Liuzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 78%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:51</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.75</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 77%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:09</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.74</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 77%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:09</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>101.4.136.34</td> \n" +
            "            <td>81</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 75%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:02</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>116.114.19.204</td> \n" +
            "            <td>443</td> \n" +
            "            <td>Nei Mongol Hohhot</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 75%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:26</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>27.203.208.30</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 74%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:04</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>119.190.147.238</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 74%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:05</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>119.179.163.242</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 73%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:16</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>116.114.19.211</td> \n" +
            "            <td>443</td> \n" +
            "            <td>Nei Mongol Hohhot</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 73%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:38</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>119.179.133.182</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 72%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:02</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>119.191.79.46</td> \n" +
            "            <td>80</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 71%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:31</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>222.74.237.246</td> \n" +
            "            <td>808</td> \n" +
            "            <td>Tianjin Tianjin</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 68%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:10</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>47.93.249.190</td> \n" +
            "            <td>8082</td> \n" +
            "            <td>浙江 Hangzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 63%; background:#dddd00;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:34</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>222.89.248.222</td> \n" +
            "            <td>59562</td> \n" +
            "            <td>河南 Zhengzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 55%; background:#dd5500;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:33</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>101.231.104.82</td> \n" +
            "            <td>80</td> \n" +
            "            <td>上海 Shanghai</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 51%; background:#dd5500;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:19</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.113</td> \n" +
            "            <td>8080</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 51%; background:#dd5500;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:12</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>119.41.192.143</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>Hainan Sheng Haikou Shi</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 41%; background:#dd5500;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:08</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>27.208.89.11</td> \n" +
            "            <td>8060</td> \n" +
            "            <td>山东 Qingdao</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 41%; background:#dd5500;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:37</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>202.104.150.130</td> \n" +
            "            <td>58729</td> \n" +
            "            <td>广东 Guangzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 39%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:31</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>47.106.196.129</td> \n" +
            "            <td>8081</td> \n" +
            "            <td>浙江 Hangzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 39%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:34</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>36.25.243.51</td> \n" +
            "            <td>80</td> \n" +
            "            <td>浙江 Hangzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 38%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:30</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>218.65.219.119</td> \n" +
            "            <td>56617</td> \n" +
            "            <td>Guangxi Fangchenggang</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 35%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:52:02</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>117.191.11.113</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 34%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:06</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>112.35.56.134</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Beijing</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 34%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:18</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>39.108.165.140</td> \n" +
            "            <td>8080</td> \n" +
            "            <td>浙江 Hangzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 32%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:28</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>60.9.1.81</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Haidian Qu</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 30%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:51:43</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>118.24.246.249</td> \n" +
            "            <td>80</td> \n" +
            "            <td>Guangxi Liuzhou</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 29%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:25</td> \n" +
            "           </tr> \n" +
            "           <tr> \n" +
            "            <td>60.9.1.80</td> \n" +
            "            <td>80</td> \n" +
            "            <td>北京 Haidian Qu</td> \n" +
            "            <td> \n" +
            "             <div class=\"graph\">\n" +
            "              <strong class=\"bar\" style=\"width: 26%; background:#dd0000;\"><span></span></strong>\n" +
            "             </div> </td> \n" +
            "            <td>2019-07-13 15:50:57</td> \n" +
            "           </tr> \n" +
            "          </tbody> \n" +
            "         </table> \n" +
            "        </div> \n" +
            "        <div style=\"font-size:0px;height:0px;line-height:0px;margin:0;padding:0;clear:both\"></div> \n" +
            "       </div> \n" +
            "      </div> \n" +
            "     </div> \n" +
            "     <div class=\"col-btm\"> \n" +
            "     </div> \n" +
            "     <div id=\"comments\"> \n" +
            "      <div id=\"respond\"> \n" +
            "       <h3 id=\"reply-title\">发表评论 <small><a rel=\"nofollow\" id=\"cancel-comment-reply-link\" href=\"/#respond\" style=\"display:none;\">取消回复</a></small></h3> \n" +
            "       <p class=\"must-log-in\">要发表评论，您必须先<a href=\"https://cn-proxy.com/wp-login.php?redirect_to=https%3A%2F%2Fcn-proxy.com%2F\">登录</a>。</p> \n" +
            "      </div>\n" +
            "      <!-- #respond --> \n" +
            "      <script>\n" +
            "document.getElementById('comment').onkeydown = function ctrlEnter(e){\n" +
            "\tif (!e) var e = window.event;\n" +
            "\tif(e.ctrlKey && e.keyCode == 13){\n" +
            "\t\tdocument.getElementById(\"submit\").click();\n" +
            "\t}\n" +
            "}\n" +
            "</script> \n" +
            "     </div>\n" +
            "     <!-- #comments --> \n" +
            "    </div> \n" +
            "    <div id=\"aside\"> \n" +
            "     <div class=\"aside-top\"></div> \n" +
            "     <div class=\"aside-mid\"> \n" +
            "      <div class=\"aside-body\"> \n" +
            "       <ul> \n" +
            "        <li id=\"recent-posts-2\" class=\"widget widget_recent_entries\"> <h3 class=\"widgettitle\">近期文章</h3> \n" +
            "         <ul> \n" +
            "          <li> <a href=\"https://cn-proxy.com/archives/1207\" title=\"临时首页\">临时首页</a> </li> \n" +
            "          <li> <a href=\"https://cn-proxy.com/archives/1183\" title=\"Windows10系统中Edge浏览器怎样设置代理【图文教程】\">Windows10系统中Edge浏览器怎样设置代理【图文教程】</a> </li> \n" +
            "          <li> <a href=\"https://cn-proxy.com/archives/1178\" title=\"海外在线观看《花千骨》\">海外在线观看《花千骨》</a> </li> \n" +
            "          <li> <a href=\"https://cn-proxy.com/archives/561\" title=\"如何在海外看世界杯\">如何在海外看世界杯</a> </li> \n" +
            "          <li> <a href=\"https://cn-proxy.com/archives/218\" title=\"全球范围内代理服务器\">全球范围内代理服务器</a> </li> \n" +
            "         </ul> </li> \n" +
            "        <li id=\"text-2\" class=\"widget widget_text\"><h3 class=\"widgettitle\">你感兴趣的</h3> \n" +
            "         <div class=\"textwidget\">\n" +
            "          <script async=\"\" src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script> \n" +
            "          <!-- 新右侧矩形1 --> \n" +
            "          <ins class=\"adsbygoogle\" style=\"display:block\" data-ad-client=\"ca-pub-6375232430051118\" data-ad-slot=\"2413128314\" data-ad-format=\"auto\" data-full-width-responsive=\"true\"></ins> \n" +
            "          <script>\n" +
            "(adsbygoogle = window.adsbygoogle || []).push({});\n" +
            "</script>\n" +
            "         </div> </li> \n" +
            "        <li id=\"tag_cloud-2\" class=\"widget widget_tag_cloud\"><h3 class=\"widgettitle\">标签</h3>\n" +
            "         <div class=\"tagcloud\">\n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/chrome\" class=\"tag-link-14\" title=\"1 个话题\" style=\"font-size: 8pt;\">chrome</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/cntv\" class=\"tag-link-16\" title=\"1 个话题\" style=\"font-size: 8pt;\">CNTV</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/ie\" class=\"tag-link-12\" title=\"1 个话题\" style=\"font-size: 8pt;\">IE</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/ios\" class=\"tag-link-9\" title=\"1 个话题\" style=\"font-size: 8pt;\">ios</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/ipad\" class=\"tag-link-11\" title=\"1 个话题\" style=\"font-size: 8pt;\">ipad</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/iphone\" class=\"tag-link-10\" title=\"1 个话题\" style=\"font-size: 8pt;\">iphone</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/qq%e9%9f%b3%e4%b9%90\" class=\"tag-link-5\" title=\"1 个话题\" style=\"font-size: 8pt;\">qq音乐</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e4%b8%96%e7%95%8c%e6%9d%af\" class=\"tag-link-22\" title=\"1 个话题\" style=\"font-size: 8pt;\">世界杯</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e4%b8%ad%e5%9b%bdip\" class=\"tag-link-6\" title=\"2 个话题\" style=\"font-size: 16.4pt;\">中国ip</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e4%bb%a3%e7%90%86\" class=\"tag-link-8\" title=\"3 个话题\" style=\"font-size: 22pt;\">代理</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e5%85%b0%e9%99%b5%e7%8e%8b\" class=\"tag-link-19\" title=\"1 个话题\" style=\"font-size: 8pt;\">兰陵王</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e8%8a%b1%e9%9d%9e%e8%8a%b1%e9%9b%be%e9%9d%9e%e9%9b%be\" class=\"tag-link-18\" title=\"1 个话题\" style=\"font-size: 8pt;\">花非花雾非雾</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e8%ae%be%e7%bd%ae\" class=\"tag-link-15\" title=\"1 个话题\" style=\"font-size: 8pt;\">设置</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e8%b0%b7%e6%ad%8c\" class=\"tag-link-13\" title=\"1 个话题\" style=\"font-size: 8pt;\">谷歌</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e9%85%b7%e7%8b%97\" class=\"tag-link-7\" title=\"1 个话题\" style=\"font-size: 8pt;\">酷狗</a> \n" +
            "          <a href=\"https://cn-proxy.com/archives/tag/%e9%be%99%e9%97%a8%e9%95%96%e5%b1%80\" class=\"tag-link-20\" title=\"1 个话题\" style=\"font-size: 8pt;\">龙门镖局</a>\n" +
            "         </div> </li> \n" +
            "       </ul> \n" +
            "       <ul class=\"aside-ul-btm\"> \n" +
            "        <li id=\"archives-3\" class=\"widget widget_archive\"><h3 class=\"widgettitle\">文章归档</h3> \n" +
            "         <ul> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2016/10\" title=\"2016 年十月\">2016 年十月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2015/10\" title=\"2015 年十月\">2015 年十月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2015/07\" title=\"2015 年七月\">2015 年七月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2014/05\" title=\"2014 年五月\">2014 年五月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2013/10\" title=\"2013 年十月\">2013 年十月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2013/09\" title=\"2013 年九月\">2013 年九月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2013/08\" title=\"2013 年八月\">2013 年八月</a></li> \n" +
            "          <li><a href=\"https://cn-proxy.com/archives/date/2013/07\" title=\"2013 年七月\">2013 年七月</a></li> \n" +
            "         </ul> </li> \n" +
            "        <li id=\"categories-2\" class=\"widget widget_categories\"><h3 class=\"widgettitle\">分类目录</h3> \n" +
            "         <ul> \n" +
            "          <li class=\"cat-item cat-item-3\"><a href=\"https://cn-proxy.com/archives/category/howto\" title=\"查看 代理服务器设置教程 下的所有文章\">代理服务器设置教程</a> </li> \n" +
            "          <li class=\"cat-item cat-item-1\"><a href=\"https://cn-proxy.com/archives/category/uncategorized\" title=\"查看 未分类 下的所有文章\">未分类</a> </li> \n" +
            "          <li class=\"cat-item cat-item-17\"><a href=\"https://cn-proxy.com/archives/category/hot-videos\" title=\"在海外如何观看国内各种热门剧集、电影的指南。\">热门剧观看指南</a> </li> \n" +
            "         </ul> </li> \n" +
            "        <li id=\"linkcat-0\" class=\"widget widget_links\"><h3 class=\"widgettitle\">书签</h3> \n" +
            "         <ul class=\"xoxo blogroll\"> \n" +
            "          <li><a href=\"http://vpncn.net/\" target=\"_blank\">中国VPN</a></li> \n" +
            "          <li><a href=\"http://rxsg173.com\" rel=\"me\" target=\"_blank\">热血三国名将查询</a></li> \n" +
            "         </ul> </li> \n" +
            "       </ul> \n" +
            "       <ul class=\"aside-ul-btm fright\"> \n" +
            "        <li id=\"meta\" class=\"widget widget_meta\"> <h3 class=\"widget-title\">功能</h3> \n" +
            "         <ul> \n" +
            "          <li><a rel=\"nofollow\" href=\"https://cn-proxy.com/wp-login.php?action=register\">注册</a></li> \n" +
            "          <li><a rel=\"nofollow\" href=\"https://cn-proxy.com/wp-login.php\">登录</a></li> \n" +
            "         </ul> </li> \n" +
            "       </ul> \n" +
            "      </div> \n" +
            "     </div> \n" +
            "     <div class=\"aside-btm\"></div> \n" +
            "    </div> \n" +
            "   </div> \n" +
            "   <div id=\"footer\"> \n" +
            "    <a id=\"gotop\" href=\"#top\" title=\"返回顶部\">返回顶部</a> \n" +
            "    <span> &copy; 2011 <a href=\"https://cn-proxy.com/\" title=\"中国ip地址\" rel=\"home\">中国ip地址</a> / Powered by <a href=\"http://wordpress.org/\" title=\"优雅的个人发布平台\" target=\"_blank\" rel=\"generator\">WordPress</a> / Piol Theme by <a href=\"http://c7sky.com/\" title=\"Designed By Cople\" target=\"_blank\">C7SKY.COM</a> </span> \n" +
            "   </div> \n" +
            "  </div> \n" +
            "  <div class=\"tongji\">\n" +
            "   <script src=\"http://s22.cnzz.com/stat.php?id=5540483&amp;web_id=5540483&amp;show=pic\" language=\"JavaScript\"></script>\n" +
            "  </div>\n" +
            "  <script src=\"https://cn-proxy.com/wp-content/themes/piol/js/ready.js\"></script> \n" +
            "  <!--[if IE 6]><script src=\"https://cn-proxy.com/wp-content/themes/piol/js/DD_belatedPNG.js\"></script><script>DD_belatedPNG.fix('#header,#masthead,#logo img,#rss img,.col-top,.col-mid,.col-btm,.aside-top,.aside-mid,.aside-btm,#footer')</script><![endif]-->  \n" +
            " </body>\n" +
            "</html>";

    public CnProxyCrawlerJob(ConcurrentLinkedQueue<ProxyIp> proxyIpQueue, String pageUrl) {
        super(proxyIpQueue, pageUrl);
    }

    @Override
    public void parsePage(WebPage webPage) {

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
            }
        }
    }
}
