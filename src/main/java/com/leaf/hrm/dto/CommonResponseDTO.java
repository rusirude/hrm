package com.leaf.hrm.dto;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public class CommonResponseDTO {
    private String code;
    private String message;
    private Object object;

    public CommonResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponseDTO(String code, Object object) {
        this.code = code;
        this.object = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
