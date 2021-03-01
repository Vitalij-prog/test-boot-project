package org.vital.bootproject.mapper;

import lombok.Data;

@Data
public class OrderListRequest {
    private int id;
    private int page;
    private int size;
}
