package com.develogical.web;

import java.io.PrintWriter;

public class ResultsPage extends HtmlPage {

    private final String query;
    private final String answer;

    public ResultsPage(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    @Override
    protected void writeContentTo(PrintWriter writer) {

        if (answer == null || answer.isEmpty()) {
            writer.println("<h1>Sorry</h1>");
            writer.print("<p>Sorry, we didn't understand <em>" + escapeHTML(query) + "</em></p>");
        } else {
            writer.println("<h1>" + escapeHTML(query) + "</h1>");
            writer.println("<p>" + escapeHTML(answer) + "</p>");
        }

        writer.println("<p><a href=\"/\">Back to Search Page</a></p>");
    }

    // https://stackoverflow.com/a/25228492/4652564
    public static String escapeHTML(String s) {
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
                out.append("&#");
                out.append((int) c);
                out.append(';');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }
}
