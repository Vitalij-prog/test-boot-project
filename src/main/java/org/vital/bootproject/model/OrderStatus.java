package org.vital.bootproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderStatus {

    ACCEPTED("accepted"),
    PROCESSING("processing"),
    IN_DELIVERY("in delivery"),
    COMPLETED("completed");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    /*public static OrderStatus getStatus(final String dbStatus) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.status.equalsIgnoreCase(dbStatus)) {
                return orderStatus;
            }
        }
    }*/

    public String getStatus() {
        return status;
    }
}
