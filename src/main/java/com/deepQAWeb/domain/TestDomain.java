package com.deepQAWeb.domain;

public class TestDomain {
    private String testInfo;
    private String testId;
    private String wrongCode1;
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

    public String getWrongCode1() {
        return wrongCode1;
    }

    public void setWrongCode1(String wrongCode1) {
        this.wrongCode1 = wrongCode1;
    }

    @Override
    public String toString() {
        return "TestDomain{" +
                "testInfo='" + testInfo + '\'' +
                ", testId='" + testId + '\'' +
                ", wrongCode1='" + wrongCode1 + '\'' +
                '}';
    }
}
