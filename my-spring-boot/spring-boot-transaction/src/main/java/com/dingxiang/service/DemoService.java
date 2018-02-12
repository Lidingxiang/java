package com.dingxiang.service;

import com.dingxiang.domain.Person;

public interface DemoService {

    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithoutRollBack(Person person);
}
