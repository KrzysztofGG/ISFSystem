package json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import commons.LocalTimeHandler;

import java.time.LocalTime;
import java.util.List;

/**
 * class representing the
 * store json object
 */
public class Store {
    private List<String> pickers;
    @JsonDeserialize(using = LocalTimeHandler.class)
    private LocalTime pickingStartTime;
    @JsonDeserialize(using = LocalTimeHandler.class)
    private LocalTime pickingEndTime;

    public Store() {
        //required for json reader
    }


    public List<String> getPickers() {
        return pickers;
    }

    @Override
    public String toString() {
        return "Store{" +
                "pickers=" + pickers +
                ", pickingStartTime=" + pickingStartTime +
                ", pickingEndTime=" + pickingEndTime +
                '}';
    }

    public LocalTime getPickingStartTime() {
        return pickingStartTime;
    }

    public LocalTime getPickingEndTime() {
        return pickingEndTime;
    }
}