package com.deepQAWeb.domain;

public class TestDomain {
    private String testInfo;
    private String testId;
    public String getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(String testInfo) {
        this.testInfo = testInfo;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "TestDomain{" +
                "testInfo='" + testInfo + '\'' +
                ", testId='" + testId + '\'' +
                '}';
    }
}
