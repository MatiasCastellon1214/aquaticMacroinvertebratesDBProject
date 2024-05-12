package com.mjc.macroinvertebratesCommunity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganismDto {
    private Long id;
    private String campaign;
    private String classTaxa;
    private String orderTaxa;
    private String family;
    private int n;
}
