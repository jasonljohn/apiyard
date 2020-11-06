package com.apiyard;

/*
 * This is Post blueprint
 */

public class Post {
    private String title;
    private String body;
    private int id;
    private int userId;


    public Post(){

    }

    public Post(String title, String message, int id) {
        this.title = title;
        this.body = message;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString(){
        return "Post: " + getId() + "\n" + " has a title of: " + "<<" + getTitle() + ">>"+ "\n" +
                " and message is: " + " " + getBody() + "\n";
    }
}