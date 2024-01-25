import controller.BankController;
import dao.BankDAO;

public class BankApp {
    public static void main(String[] args) {
        String uri = "/withdraw";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);
        dis.route(uri);
    }
}