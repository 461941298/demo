package com.yjh.pattern.actionType.resposibility;

/**
 * Author: yjh
 * Date: 2018/5/2 22:52
 * Version: 1.0
 * Description:
 */
public abstract class RequestHandler {

    protected RequestHandler requestHandler;

    protected abstract boolean handleRequest(Object object);

    public RequestHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}

class NumberType extends RequestHandler {

    @Override
    protected boolean handleRequest(Object object) {

        try {
            Number number = (Number) object;
            System.out.println("这是个数字:" + number);
            return true;
        } catch (Exception e) {
            return requestHandler.handleRequest(object);
        }
    }
}

class StringType extends RequestHandler {

    @Override
    protected boolean handleRequest(Object object) {
        try {
            String str = (String) object;
            System.out.println("这是个字符串:" + str);
            return true;
        } catch (Exception e) {
            return requestHandler.handleRequest(object);
        }
    }
}

class ObjectType extends RequestHandler {

    @Override
    protected boolean handleRequest(Object object) {
        System.out.println("这是一个对象:" + object);
        return true;
    }
}
