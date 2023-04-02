package commons;

import json.Order;
import json.Store;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class responsible for program logic
 */
public class Logic {

    List<Order> orders;
    Map<String, LocalTime> pickerReady;

    List<String> lines;
    Store store;
    public Logic(Store store, List<Order> orders){
        this.store = store;
        this.orders = orders;
        setUp();
    }

    /**
     * Function that does
     * the magic
     */
    public void findPickerOrders(){
        for(Order order : orders){

                for(Map.Entry<String, LocalTime> set : pickerReady.entrySet()){
                    if((set.getValue().
                            plus(order.getPickingTime()).
                            compareTo(order.getCompleteBy()) <= 0) &&
                            (set.getValue().
                                    plus(order.getPickingTime()).
                                    compareTo(store.getPickingEndTime()) <= 0)){



                        String line = set.getKey() + " " + order.getOrderId() + " " + set.getValue().toString();
                        lines.add(line);

                        pickerReady.put(set.getKey(), set.getValue().plus(order.getPickingTime()));
                        break;
                    }
                }


        }
    }
    public void printOutput(){
        for(String line : lines)
            System.out.println(line);
    }

    /**
     * class initializer
     */
    private void setUp(){
        pickerReady = new HashMap<>();
        lines = new ArrayList<>();
        for(String picker: store.getPickers()){
            pickerReady.put(picker, store.getPickingStartTime());
        }
    }

    public List<String> getLines() {
        return lines;
    }
}
