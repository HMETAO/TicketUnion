package com.hmetao.ticketunion.model.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class HomePageContent {
    @Override
    public String toString() {
        return "HomePageContent{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Long code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataDTO> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataDTO dataDTO = (DataDTO) o;
            return Objects.equals(categoryId, dataDTO.categoryId) && Objects.equals(clickUrl, dataDTO.clickUrl) && Objects.equals(commissionRate, dataDTO.commissionRate) && Objects.equals(couponAmount, dataDTO.couponAmount) && Objects.equals(couponClickUrl, dataDTO.couponClickUrl) && Objects.equals(couponEndTime, dataDTO.couponEndTime) && Objects.equals(couponRemainCount, dataDTO.couponRemainCount) && Objects.equals(couponShareUrl, dataDTO.couponShareUrl) && Objects.equals(couponStartFee, dataDTO.couponStartFee) && Objects.equals(couponStartTime, dataDTO.couponStartTime) && Objects.equals(couponTotalCount, dataDTO.couponTotalCount) && Objects.equals(itemDescription, dataDTO.itemDescription) && Objects.equals(itemId, dataDTO.itemId) && Objects.equals(levelOneCategoryId, dataDTO.levelOneCategoryId) && Objects.equals(levelOneCategoryName, dataDTO.levelOneCategoryName) && Objects.equals(pictUrl, dataDTO.pictUrl) && Objects.equals(reservePrice, dataDTO.reservePrice) && Objects.equals(sellerId, dataDTO.sellerId) && Objects.equals(shortTitle, dataDTO.shortTitle) && Objects.equals(smallImages, dataDTO.smallImages) && Objects.equals(subTitle, dataDTO.subTitle) && Objects.equals(title, dataDTO.title) && Objects.equals(tmallPlayActivityEndTime, dataDTO.tmallPlayActivityEndTime) && Objects.equals(tmallPlayActivityStartTime, dataDTO.tmallPlayActivityStartTime) && Objects.equals(userType, dataDTO.userType) && Objects.equals(volume, dataDTO.volume) && Objects.equals(zkFinalPrice, dataDTO.zkFinalPrice);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryId, clickUrl, commissionRate, couponAmount, couponClickUrl, couponEndTime, couponRemainCount, couponShareUrl, couponStartFee, couponStartTime, couponTotalCount, itemDescription, itemId, levelOneCategoryId, levelOneCategoryName, pictUrl, reservePrice, sellerId, shortTitle, smallImages, subTitle, title, tmallPlayActivityEndTime, tmallPlayActivityStartTime, userType, volume, zkFinalPrice);
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "categoryId=" + categoryId +
                    ", clickUrl='" + clickUrl + '\'' +
                    ", commissionRate='" + commissionRate + '\'' +
                    ", couponAmount=" + couponAmount +
                    ", couponClickUrl='" + couponClickUrl + '\'' +
                    ", couponEndTime='" + couponEndTime + '\'' +
                    ", couponRemainCount=" + couponRemainCount +
                    ", couponShareUrl='" + couponShareUrl + '\'' +
                    ", couponStartFee='" + couponStartFee + '\'' +
                    ", couponStartTime='" + couponStartTime + '\'' +
                    ", couponTotalCount=" + couponTotalCount +
                    ", itemDescription='" + itemDescription + '\'' +
                    ", itemId='" + itemId + '\'' +
                    ", levelOneCategoryId=" + levelOneCategoryId +
                    ", levelOneCategoryName='" + levelOneCategoryName + '\'' +
                    ", pictUrl='" + pictUrl + '\'' +
                    ", reservePrice='" + reservePrice + '\'' +
                    ", sellerId=" + sellerId +
                    ", shortTitle=" + shortTitle +
                    ", smallImages=" + smallImages +
                    ", subTitle='" + subTitle + '\'' +
                    ", title='" + title + '\'' +
                    ", tmallPlayActivityEndTime=" + tmallPlayActivityEndTime +
                    ", tmallPlayActivityStartTime=" + tmallPlayActivityStartTime +
                    ", userType=" + userType +
                    ", volume=" + volume +
                    ", zkFinalPrice='" + zkFinalPrice + '\'' +
                    '}';
        }

        @SerializedName("category_id")
        private Long categoryId;
        @SerializedName("click_url")
        private String clickUrl;
        @SerializedName("commission_rate")
        private String commissionRate;
        @SerializedName("coupon_amount")
        private Long couponAmount;
        @SerializedName("coupon_click_url")
        private String couponClickUrl;
        @SerializedName("coupon_end_time")
        private String couponEndTime;
        @SerializedName("coupon_remain_count")
        private Long couponRemainCount;
        @SerializedName("coupon_share_url")
        private String couponShareUrl;
        @SerializedName("coupon_start_fee")
        private String couponStartFee;
        @SerializedName("coupon_start_time")
        private String couponStartTime;
        @SerializedName("coupon_total_count")
        private Long couponTotalCount;
        @SerializedName("item_description")
        private String itemDescription;
        @SerializedName("item_id")
        private String itemId;
        @SerializedName("level_one_category_id")
        private Long levelOneCategoryId;
        @SerializedName("level_one_category_name")
        private String levelOneCategoryName;
        @SerializedName("pict_url")
        private String pictUrl;
        @SerializedName("reserve_price")
        private String reservePrice;
        @SerializedName("seller_id")
        private Long sellerId;
        @SerializedName("short_title")
        private Object shortTitle;
        @SerializedName("small_images")
        private SmallImagesDTO smallImages;
        @SerializedName("sub_title")
        private String subTitle;
        @SerializedName("title")
        private String title;
        @SerializedName("tmall_play_activity_end_time")
        private Long tmallPlayActivityEndTime;
        @SerializedName("tmall_play_activity_start_time")
        private Long tmallPlayActivityStartTime;
        @SerializedName("user_type")
        private Long userType;
        @SerializedName("volume")
        private Long volume;
        @SerializedName("zk_final_price")
        private String zkFinalPrice;

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public String getClickUrl() {
            return clickUrl;
        }

        public void setClickUrl(String clickUrl) {
            this.clickUrl = clickUrl;
        }

        public String getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(String commissionRate) {
            this.commissionRate = commissionRate;
        }

        public Long getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(Long couponAmount) {
            this.couponAmount = couponAmount;
        }

        public String getCouponClickUrl() {
            return couponClickUrl;
        }

        public void setCouponClickUrl(String couponClickUrl) {
            this.couponClickUrl = couponClickUrl;
        }

        public String getCouponEndTime() {
            return couponEndTime;
        }

        public void setCouponEndTime(String couponEndTime) {
            this.couponEndTime = couponEndTime;
        }

        public Long getCouponRemainCount() {
            return couponRemainCount;
        }

        public void setCouponRemainCount(Long couponRemainCount) {
            this.couponRemainCount = couponRemainCount;
        }

        public String getCouponShareUrl() {
            return couponShareUrl;
        }

        public void setCouponShareUrl(String couponShareUrl) {
            this.couponShareUrl = couponShareUrl;
        }

        public String getCouponStartFee() {
            return couponStartFee;
        }

        public void setCouponStartFee(String couponStartFee) {
            this.couponStartFee = couponStartFee;
        }

        public String getCouponStartTime() {
            return couponStartTime;
        }

        public void setCouponStartTime(String couponStartTime) {
            this.couponStartTime = couponStartTime;
        }

        public Long getCouponTotalCount() {
            return couponTotalCount;
        }

        public void setCouponTotalCount(Long couponTotalCount) {
            this.couponTotalCount = couponTotalCount;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public Long getLevelOneCategoryId() {
            return levelOneCategoryId;
        }

        public void setLevelOneCategoryId(Long levelOneCategoryId) {
            this.levelOneCategoryId = levelOneCategoryId;
        }

        public String getLevelOneCategoryName() {
            return levelOneCategoryName;
        }

        public void setLevelOneCategoryName(String levelOneCategoryName) {
            this.levelOneCategoryName = levelOneCategoryName;
        }

        public String getPictUrl() {
            return pictUrl;
        }

        public void setPictUrl(String pictUrl) {
            this.pictUrl = pictUrl;
        }

        public String getReservePrice() {
            return reservePrice;
        }

        public void setReservePrice(String reservePrice) {
            this.reservePrice = reservePrice;
        }

        public Long getSellerId() {
            return sellerId;
        }

        public void setSellerId(Long sellerId) {
            this.sellerId = sellerId;
        }

        public Object getShortTitle() {
            return shortTitle;
        }

        public void setShortTitle(Object shortTitle) {
            this.shortTitle = shortTitle;
        }

        public SmallImagesDTO getSmallImages() {
            return smallImages;
        }

        public void setSmallImages(SmallImagesDTO smallImages) {
            this.smallImages = smallImages;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getTmallPlayActivityEndTime() {
            return tmallPlayActivityEndTime;
        }

        public void setTmallPlayActivityEndTime(Long tmallPlayActivityEndTime) {
            this.tmallPlayActivityEndTime = tmallPlayActivityEndTime;
        }

        public Long getTmallPlayActivityStartTime() {
            return tmallPlayActivityStartTime;
        }

        public void setTmallPlayActivityStartTime(Long tmallPlayActivityStartTime) {
            this.tmallPlayActivityStartTime = tmallPlayActivityStartTime;
        }

        public Long getUserType() {
            return userType;
        }

        public void setUserType(Long userType) {
            this.userType = userType;
        }

        public Long getVolume() {
            return volume;
        }

        public void setVolume(Long volume) {
            this.volume = volume;
        }

        public String getZkFinalPrice() {
            return zkFinalPrice;
        }

        public void setZkFinalPrice(String zkFinalPrice) {
            this.zkFinalPrice = zkFinalPrice;
        }

        public static class SmallImagesDTO {
            @SerializedName("string")
            private List<String> string;

            public List<String> getString() {
                return string;
            }

            public void setString(List<String> string) {
                this.string = string;
            }
        }
    }
}
