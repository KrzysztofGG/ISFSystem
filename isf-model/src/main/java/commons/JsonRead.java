package commons;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.Order;
import json.Store;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * class reading
 * from json files
 */
public class JsonRead {

    /**
     * safety net made
     * not to initialise
     * the static member
     */
    private JsonRead(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * function reads orders from json file
     * to a list
     * @param ordersPath - path to orders.json file
     * @return - list of orders from file
     */
    public static List<Order> readOrders(String ordersPath){
        List<Order> orders;
        try {
            Path filePath = Path.of(ordersPath);
            ObjectMapper mapper = new ObjectMapper();
            String ordersJson = Files.readString(filePath);
            orders = mapper.readValue(ordersJson, new TypeReference<ArrayList<Order>>(){});
            orders.sort((o1, o2) -> new CompareToBuilder().
                            append(o1.getCompleteBy(), o2.getCompleteBy()).
                            append(o1.getOrderValue(), o2.getOrderValue()).
                            append(o1.getPickingTime(), o2.getPickingTime()).toComparison());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    /**
     * function reads the store object from
     * json file
     * @param storePath - path to store.json file
     * @return - new Store object
     */
    public static Store readStore(String storePath){
        try{
            Path filePath = Path.of(storePath);
            ObjectMapper mapper = new ObjectMapper();
            String storeJson = Files.readString(filePath);
            return mapper.readValue(storeJson, new TypeReference<Store>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
