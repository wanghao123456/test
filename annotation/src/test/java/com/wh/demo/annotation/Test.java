package com.wh.demo.annotation;

public class Test {


    public static void main(String[] args) {
        Server server = new Server(
                new User("1", "2", new User1("1", "2"))
                , new User("3", "4", new User1("1", "2"))
                , new User("5", "6", new User1(null, null)));

        CheckResult checkResult = ParamCheckUtil.check(server);
        System.out.println(checkResult);
    }
}
