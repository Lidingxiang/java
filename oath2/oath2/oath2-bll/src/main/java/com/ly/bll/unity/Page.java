package com.ly.bll.unity;

import cicada.core.BeanFactory;
import org.springframework.core.env.Environment;

public class Page {
    public static int pageSize = -1;

    public static int getStart(int pageIndex) {
        int start = 0;
        if (pageIndex > 1) {
            start = getPageSize() * (pageIndex - 1);
        }
        return start;
    }

    public static int getPageSize() {
        if (pageSize == -1) {
            calPageSize();
        }
        return pageSize;
    }

    private static void calPageSize() {
        Environment environment = BeanFactory.getBeanByType(Environment.class);
        pageSize = Integer.valueOf(environment.getProperty("sys.pagesize"));
    }
}
