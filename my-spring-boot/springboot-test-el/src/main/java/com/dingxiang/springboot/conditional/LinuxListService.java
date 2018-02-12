package com.dingxiang.springboot.conditional;

public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {

        return "ls";
    }
}
