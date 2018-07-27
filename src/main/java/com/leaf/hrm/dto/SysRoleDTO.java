package com.leaf.hrm.dto;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public class SysRoleDTO extends CommonDTO{
    private String code;
    private String description;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
