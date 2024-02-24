package com.hmetao.ticketunion.model.domain;

import com.google.gson.annotations.SerializedName;

public class TicketResult {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTO data;

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

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        @SerializedName("tbk_tpwd_create_response")
        private TbkTpwdCreateResponseDTO tbkTpwdCreateResponse;

        public TbkTpwdCreateResponseDTO getTbkTpwdCreateResponse() {
            return tbkTpwdCreateResponse;
        }

        public void setTbkTpwdCreateResponse(TbkTpwdCreateResponseDTO tbkTpwdCreateResponse) {
            this.tbkTpwdCreateResponse = tbkTpwdCreateResponse;
        }

        public static class TbkTpwdCreateResponseDTO {
            @SerializedName("data")
            private DataSonDTO data;
            @SerializedName("request_id")
            private String requestId;

            public DataSonDTO getData() {
                return data;
            }

            public void setData(DataSonDTO data) {
                this.data = data;
            }

            public String getRequestId() {
                return requestId;
            }

            public void setRequestId(String requestId) {
                this.requestId = requestId;
            }

            public static class DataSonDTO {
                @SerializedName("model")
                private String model;

                public String getModel() {
                    return model;
                }

                public void setModel(String model) {
                    this.model = model;
                }
            }
        }
    }
}
