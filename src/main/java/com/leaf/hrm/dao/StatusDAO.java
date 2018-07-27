package com.leaf.hrm.dao;

import com.leaf.hrm.entity.Status;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public interface StatusDAO {

    /**
     * Get Status By code from DB
     *
     * @param code - code of Status
     * @return Status
     */
    Status findStatusByCode(String code);

    /**
     * Update Status
     */
    void updateStatus(Status status);
}
