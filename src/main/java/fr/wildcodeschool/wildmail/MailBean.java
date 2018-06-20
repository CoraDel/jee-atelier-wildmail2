package fr.wildcodeschool.wildmail;

import java.io.Serializable;

public class MailBean implements Serializable {

    private int id;
    private String from;
    private String to;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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