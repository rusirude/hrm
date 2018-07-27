package com.leaf.hrm.dao;

import com.leaf.hrm.entity.StatusCategory;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public interface StatusCategoryDAO {

    /**
     * Get Status Category By id from DB
     *
     * @param id - Id of Status Category
     * @return StatusCategory
     */
    StatusCategory findStatusCategory(Integer id);

    /**
     * Get Status Category by code from DB
     * @param code - code of Status Category
     * @return StatusCategory
     */
    StatusCategory findStatusCategoryByCode(String code);
}
