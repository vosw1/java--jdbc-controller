package controller;

import dao.BankDAO;

import java.lang.reflect.Method;

public class BankController {
    private BankDAO dao;

    @RequestMapping(uri = "insert")
    public void insert() {
        System.out.println("controller : insert");
        dao.insert("1234", 1000);
    }

    @RequestMapping(uri = "delete")
    public void delete() {
        System.out.println("controller : delete");
        System.out.println(5);
    }

    @RequestMapping(uri = "update")
    public void update() {
        System.out.println("controller : update");
        dao.updateByNumber(1000, 4);
    }

    @RequestMapping(uri = "selectOne")
    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNumber(4);
    }

    @RequestMapping(uri = "selectAll")
    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }

    public Method[] getMethods() {
        return getClass().getDeclaredMethods();
    }
}
