package com.deepQAWeb.domain;

public class BrandTestDomain {
    private String brandName;
    private String brandId;
    private String brandInfo;
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandInfo() {
        return brandInfo;
    }

    public void setBrandInfo(String brandInfo) {
        this.brandInfo = brandInfo;
    }

    @Override
    public String toString() {
        return "BrandTestDomain{" +
                "brandName='" + brandName + '\'' +
                ", brandId='" + brandId + '\'' +
                ", brandInfo='" + brandInfo + '\'' +
                '}';
    }
}
