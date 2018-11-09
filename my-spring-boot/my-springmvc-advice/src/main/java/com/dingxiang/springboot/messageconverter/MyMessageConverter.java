package com.dingxiang.springboot.messageconverter;

import com.dingxiang.springboot.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {//1

    public MyMessageConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));//2
    }

    /**
     * 3
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {

        String temp = StreamUtils.copyToString(inputMessage.getBody(),Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]), tempArr[1]);
    }

    /**
     * 4
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        String a1=Integer.toString(11);
        int a2=Integer.parseInt("22");

        String a3= String.valueOf("222");
        



        return DemoObj.class.isAssignableFrom(clazz);
    }

    /**
     * 5
     */
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + obj.getId() + "-" + obj.getName();
        outputMessage.getBody().write(out.getBytes());
    }
}
