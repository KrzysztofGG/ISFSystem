package json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import commons.DurationHandler;
import commons.LocalTimeHandler;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

/**
 * class representing an
 * order from json file
 */
public class Order {
    private String orderId;
    private BigDecimal orderValue;
    @JsonDeserialize(using = DurationHandler.class)
    private Duration pickingTime;

    @JsonDeserialize(using = LocalTimeHandler.class)
    private LocalTime completeBy;

    public Order(){}

    public Order(String orderId, BigDecimal orderValue, Duration pickingTime, LocalTime completeBy) {
        this.orderId = orderId;
        this.orderValue = orderValue;
        this.pickingTime = pickingTime;
        this.completeBy = completeBy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(BigDecimal orderValue) {
        this.orderValue = orderValue;
    }

    public Duration getPickingTime() {
        return pickingTime;
    }

    public void setPickingTime(Duration pickingTime) {
        this.pickingTime = pickingTime;
    }

    public LocalTime getCompleteBy() {
        return completeBy;
    }

    public void setCompleteBy(LocalTime completeBy) {
        this.completeBy = completeBy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderValue=" + orderValue +
                ", pickingTime=" + pickingTime +
                ", completeBy=" + completeBy +
                '}';
    }
}
