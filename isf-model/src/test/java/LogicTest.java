import commons.JsonRead;
import commons.Logic;
import json.Order;
import json.Store;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class LogicTest {
    @Test
    public void systemLogicTest(){
        ArrayList<Order> orders = new ArrayList<>(JsonRead.
                readOrders("src/main/resources/orders.json"));
        Store store = JsonRead.
                readStore("src/main/resources/store.json");
        Logic logic = new Logic(store, orders);

        logic.findPickerOrders();
        assertEquals(1, logic.getLines().size());
    }
}
