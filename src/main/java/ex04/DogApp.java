package ex04;

public class DogApp {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String className = "ex04.Dog";

        Class cls = Class.forName(className);
        Object ob = cls.newInstance();

        Dog d = (Dog) ob;
        System.out.println(d.name);
    }
}
