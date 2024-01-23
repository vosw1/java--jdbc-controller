import controller.BankController;

public class BankApp {
    public static void main(String[] args) {
        String uri = "selectAll";

        BankController controller = new BankController();
        Dispatcher dispatcher = new Dispatcher(controller);

        dispatcher.route(uri);
    }
}