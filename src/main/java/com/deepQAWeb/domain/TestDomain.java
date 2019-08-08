package com.deepQAWeb.domain;

public class TestDomain {
    private String testInfo;

    public String getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(String testInfo) {
        this.testInfo = testInfo;
    }

    @Override
    public String toString() {
        return "TestDomain{" +
                "testInfo='" + testInfo + '\'' +
                '}';
    }
}
