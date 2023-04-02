package main;

import commons.JsonRead;
import commons.Logic;
import json.Order;
import json.Store;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if(args.length >= 2){
            String storePath = args[0];
            String ordersPath = args[1];

            ArrayList<Order> orders = new ArrayList<>(JsonRead.readOrders(ordersPath));
            Store store = JsonRead.readStore(storePath);

            Logic logic = new Logic(store, orders);
            logic.findPickerOrders();
            logic.printOutput();
        }
        else{
            throw new RuntimeException("Invalid input");
        }
    }
}
