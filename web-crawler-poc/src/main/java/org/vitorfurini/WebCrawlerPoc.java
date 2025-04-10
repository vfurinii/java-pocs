package org.vitorfurini;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WebCrawlerPoc {
    private Set<String> visited = new HashSet<>();
    private Queue<UrlDepthPair> queue = new LinkedList<>();

    //max paths
    private static final int MAX_DEPTH = 2;

    public static void main(String[] args) {
        WebCrawlerPoc crawler = new WebCrawlerPoc();
        String startUrl = "http://hiring.axreng.com/";
        crawler.startCrawling(startUrl);
    }

    public void startCrawling(String startUrl) {
        queue.add(new UrlDepthPair(startUrl, 0));

        while (!queue.isEmpty()) {
            UrlDepthPair current = queue.poll();

            if (current.depth > MAX_DEPTH || visited.contains(current.url)) {
                continue;
            }

            System.out.println("Crawling: " + current.url + " (Depth: " + current.depth + ")");
            visited.add(current.url);

            try {
                Document doc = Jsoup.connect(current.url).get();
                Elements links = doc.select("a[href]");

                for (Element link : links) {
                    String absUrl = link.absUrl("href");

                    if (!absUrl.isEmpty() && !visited.contains(absUrl)) {
                        queue.add(new UrlDepthPair(absUrl, current.depth + 1));
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao acessar: " + current.url + " - " + e.getMessage());
            }
        }
    }

    private static class UrlDepthPair {
        String url;
        int depth;

        UrlDepthPair(String url, int depth) {
            this.url = url;
            this.depth = depth;
        }
    }
}