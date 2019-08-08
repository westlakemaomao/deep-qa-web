package com.deepQAWeb.domain;

public class BrandTestDomain {
    private String brandName;
    private String brandId;
    private String brandInfo;
    private String addTest1;
    private String mergeTest1;
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

    public String getAddTest1() {
        return addTest1;
    }

    public void setAddTest1(String addTest1) {
        this.addTest1 = addTest1;
    }

    public String getMergeTest1() {
        return mergeTest1;
    }

    public void setMergeTest1(String mergeTest1) {
        this.mergeTest1 = mergeTest1;
    }

    @Override
    public String toString() {
        return "BrandTestDomain{" +
                "brandName='" + brandName + '\'' +
                ", brandId='" + brandId + '\'' +
                ", brandInfo='" + brandInfo + '\'' +
                ", addTest1='" + addTest1 + '\'' +
                ", mergeTest1='" + mergeTest1 + '\'' +
                '}';
    }
}
