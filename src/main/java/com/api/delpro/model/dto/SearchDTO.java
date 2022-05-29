package com.api.delpro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    private String sendRegion;
    private String sendCity;
    private String deliveryRegion;
    private String deliveryCity;
    private int width;
    private int length;
    private int height;
    private LocalDateTime date;
    private int km;

}
