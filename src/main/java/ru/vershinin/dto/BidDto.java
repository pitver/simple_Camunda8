package ru.vershinin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.vershinin.enums.StatusBid;

@Data
@ToString
public class BidDto {

    private String numberBid;
    private String comment;
    private StatusBid statusBid;
    private Long idClient;
    private Long inn;
    private Boolean flag;

}
