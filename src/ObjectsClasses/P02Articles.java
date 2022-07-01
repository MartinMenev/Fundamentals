package ObjectsClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02Articles {

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

        public void editContent(String content) {
            this.content = content;
        }

        public void changeAuthor (String author) {
            this.author = author;
        }

        public void renameTitle (String title) {
            this.title = title;
        }


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());
        String title = input[0];
        String content = input[1];
        String author = input [2];

        Article currentArticle = new Article(title, content, author);

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");

            if (command[0].equals("Edit")) {
                currentArticle.editContent(command[1]);
            } else if (command[0].equals("ChangeAuthor")) {
                currentArticle.changeAuthor(command[1]);
            } else if (command[0].equals("Rename")) {
                currentArticle.renameTitle(command[1]);
            }
        }

        System.out.printf("%s - %s: %s%n", currentArticle.getTitle(), currentArticle.getContent(), currentArticle.getAuthor());
    }
}
