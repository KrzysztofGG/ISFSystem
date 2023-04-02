import commons.JsonRead;
import json.Order;
import json.Store;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class ReaderTest {

    @Test
    public void readingOrdersTest(){
        ArrayList<Order> orders = new ArrayList<>(JsonRead.readOrders("src/main/resources/orders.json"));
        assertEquals(3, orders.size());
    }

    @Test
    public void sortingTest(){
        ArrayList<Order> orders = new ArrayList<>(JsonRead.readOrders("src/main/resources/orders.json"));
        assertEquals("order-3", orders.get(0).getOrderId());
    }

    @Test
    public void readStoreTest(){
        Store store = JsonRead.readStore("src/main/resources/store.json");
        assertEquals(1, store.getPickers().size());
    }

}
