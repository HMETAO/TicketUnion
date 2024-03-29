package com.hmetao.ticketunion.model.domain;

public class TicketParams {
    String url;
    String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TicketParams() {
    }

    public TicketParams(String url, String title) {
        this.url = url;
        this.title = title;
    }
}
