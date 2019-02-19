package com.wh.demo.annotation;

public class Server {

    @ParamCheck(type = ParamType.BO)
    private User u1;
    @ParamCheck(type = ParamType.BO)
    private User u2;
    @ParamCheck(type = ParamType.BO)
    private User u3;

    public Server(User u1, User u2, User u3) {
        this.u1 = u1;
        this.u2 = u2;
        this.u3 = u3;
    }
}
