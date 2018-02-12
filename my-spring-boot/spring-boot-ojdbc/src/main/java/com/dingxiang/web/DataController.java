package com.dingxiang.web;

import com.dingxiang.dao.PersonRepository;
import com.dingxiang.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    //1 Spring Data JPA已自动为你注册bean，所以可自动注入
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {

        Person p = personRepository.save(new Person(null, name, age, address));
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {

        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/q2")
    public Person q2(String name, String address) {

        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address) {

        Person p = personRepository.withNameAndAddressQuery(name, address);
        return p;
    }

    /**
     * 测试withNameAndAddressNamedQuery
     */
    @RequestMapping("/q4")
    public List<Person> q4(String name, String address) {

        List<Person> p = personRepository.withNameAndAddressNamedQuery(name, address);
        return p;
    }

    /**
     * 测试排序
     */
    @RequestMapping("/sort")
    public List<Person> sort() {

        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }

    /**
     * 测试分页
     */
    @RequestMapping("/page")
    public Page<Person> page() {

        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1, 2));
        return pagePeople;
    }
//
//
//    @RequestMapping("/auto")
//    public Page<Person> auto(Person person){
//
//        Page<Person> pagePeople = personRepository.findByAuto(person, new PageRequest(0, 10));
//
//        return pagePeople;
//
//    }
}
