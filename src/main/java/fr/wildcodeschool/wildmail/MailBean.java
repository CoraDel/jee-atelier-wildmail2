package fr.wildcodeschool.wildmail;

import java.io.Serializable;

public class MailBean implements Serializable {

    private String from;
    private String to;
    private String content;

    // contructeur vide
    public MailBean() {

    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}