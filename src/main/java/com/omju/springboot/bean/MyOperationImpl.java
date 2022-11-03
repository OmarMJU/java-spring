package com.omju.springboot.bean;

public class MyOperationImpl implements MyOperation {
    @Override
    public int add(int number) {
        return number + 1;
    }
}