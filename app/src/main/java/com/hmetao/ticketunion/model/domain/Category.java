package com.hmetao.ticketunion.model.domain;


import java.util.List;

public class Category {

    @com.google.gson.annotations.SerializedName("success")
    private Boolean success;
    @com.google.gson.annotations.SerializedName("code")
    private Integer code;
    @com.google.gson.annotations.SerializedName("message")
    private String message;
    @com.google.gson.annotations.SerializedName("data")
    private List<DataDTO> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        @com.google.gson.annotations.SerializedName("id")
        private Integer id;
        @com.google.gson.annotations.SerializedName("title")
        private String title;

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
    }
}
