package com.pavan.github.estatemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagingTo {

    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Integer totalElements;

}
