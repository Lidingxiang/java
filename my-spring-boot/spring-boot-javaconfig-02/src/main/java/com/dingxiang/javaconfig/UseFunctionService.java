package com.dingxiang.javaconfig;

public class UseFunctionService {

    FunctionService functionService;

    public UseFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

   /* public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }*/

	public String SayHello(String word){
		return functionService.sayHello(word);
	}
}
