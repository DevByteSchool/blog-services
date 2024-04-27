package com.devbyteschool.blogservice.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommonPaginationRequest {

    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String value;
}
