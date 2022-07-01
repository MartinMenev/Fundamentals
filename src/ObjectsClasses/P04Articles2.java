package ObjectsClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Articles2 {

    static class Article {
        String title;
        String content;
        String author;

        public Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(", ");
            Article currentArticle = new Article(command [0], command [1], command[2]);
            articles.add(currentArticle);
        }
        String line = scanner.nextLine();

            for (Article item : articles) {
                System.out.printf("%s - %s: %s%n", item.getTitle(), item.getContent(), item.getAuthor());
            }
    }
}
