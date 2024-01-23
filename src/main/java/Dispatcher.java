import controller.BankController;

import java.lang.reflect.Method;

public class Dispatcher {
    private BankController controller;

    public Dispatcher(BankController controller) {
        this.controller = controller;
    }

    public void route(String uri) {
        Method[] methods = controller.getMethods();

        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm != null && rm.uri().equals(uri)) {
                try {
                    method.invoke(controller);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}