package set1000.set1200.set1230.p1236;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = findHostName(startUrl);
        Set<String> result = new HashSet<>();
        Crawler crawler = new Crawler(hostName, htmlParser, result);
        crawler.crawl(startUrl);

        return new ArrayList<>(result);
    }

    static class Crawler {
        private final String hostName;
        private final HtmlParser htmlParser;
        private final Set<String> crawed;

        Crawler(String hostName, HtmlParser htmlParser, Set<String> crawled) {
            this.hostName = hostName;
            this.htmlParser = htmlParser;
            this.crawed = crawled;
        }

        public void crawl(String url) {
            String hostName = findHostName(url);
            if (!hostName.equals(this.hostName)) {
                return;
            }

            if (crawed.contains(url)) {
                return;
            }

            crawed.add(url);

            List<String> newUrls = htmlParser.getUrls(url);

            if (newUrls == null) {
                return;
            }

            for (String newUrl : newUrls) {
                Crawler child = new Crawler(this.hostName, htmlParser, crawed);
                child.crawl(newUrl);
            }
        }
    }

    private static String findHostName(String url) {
        url = url.toLowerCase();
        if (url.startsWith("http://")) {
            url = url.substring("http://".length());
        } else if (url.startsWith("https://")) {
            url = url.substring("https://".length());
        }
        int i = 0;
        while (i < url.length() && (url.charAt(i) != ':' && url.charAt(i) != '/')) {
            i++;
        }
        if (i == url.length()) {
            return url;
        }
        return url.substring(0, i);
    }
}


/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface HtmlParser {
    List<String> getUrls(String url);
}

