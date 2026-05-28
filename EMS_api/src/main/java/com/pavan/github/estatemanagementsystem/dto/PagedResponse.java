package com.pavan.github.estatemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponse<T> {

    private List<T> items;
    private PagingTo pagingTo;
    
}
