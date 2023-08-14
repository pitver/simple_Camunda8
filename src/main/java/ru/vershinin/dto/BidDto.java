package ru.vershinin.dto;

import lombok.*;
import ru.vershinin.enums.StatusBid;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidDto {

    private String numberBid;
    private String comment;
    private StatusBid statusBid;
    private Long idClient;
    private Long inn;
    private Boolean flag;

}
