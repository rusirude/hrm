package com.leaf.hrm.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public class DataTableResponseDTO implements Serializable {
    private Integer draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<?> data;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
