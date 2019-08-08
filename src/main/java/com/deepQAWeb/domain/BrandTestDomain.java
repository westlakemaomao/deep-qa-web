package com.deepQAWeb.domain;

public class BrandTestDomain {
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "BrandTestDomain{" +
                "brandName='" + brandName + '\'' +
                '}';
    }
}
