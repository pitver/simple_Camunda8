package ru.vershinin.dto;

import lombok.Data;
import ru.vershinin.enums.StatusBid;

@Data
public class BidDto {

    private String numberBid;
    private String comment;
    private StatusBid statusBid;
    private Long idClient;
    private Long Inn;
    private Boolean flag;

}
