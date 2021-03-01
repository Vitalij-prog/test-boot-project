package org.vital.bootproject.mapper;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vital.bootproject.model.OrderStatus;

import java.sql.Date;

@Data
@Builder
public class OrderResponse {
    private Date date;
    private OrderStatus orderStatus;
}
