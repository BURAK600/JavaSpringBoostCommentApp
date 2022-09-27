package com.burak.commentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateResponseDto {
    private String name;
    private Double price;
    private LocalDate expirationDate;
}
