package com.shefzee.currencyconversion.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyConversion extends BaseEntity{

    @Column
    private String sourceCurrency;
    @Column
    private String targetCurrency;
    @Column
    private Double value;
    @Column
    private LocalDate date;

}
