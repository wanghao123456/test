package com.wh.demo.annotation;

public class CheckResult {

    private boolean pass = true;
    private StringBuilder desc = new StringBuilder();
    private int count = 0;

    public void addDesc(String desc) {
        this.desc.append(++count + "、" + desc);
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public StringBuilder getDesc() {
        return desc;
    }

    public void setDesc(StringBuilder desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "pass=" + pass +
                ", desc=" + desc +
                '}';
    }
}
