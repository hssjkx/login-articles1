package xyz.oilpea.schooldemo.demo.entities;

import java.util.Date;

public class ArticlesList {
    private Integer id;
    private String title;
    private String writer;
    private Date editTime;

    public ArticlesList(Integer id, String title, String writer) {
        super();
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.editTime =new Date();
    }

    @Override
    public String toString() {
        return "ArticlesList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", editTime=" + editTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}

