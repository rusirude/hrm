package com.leaf.hrm.enums;

import com.leaf.hrm.utility.CommonConstant;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public enum StatusCategoryEnum {

    DEFAULT(CommonConstant.STATUS_CATEGORY_DEFAULT),
    DELETE(CommonConstant.STATUS_CATEGORY_DELETE);


    private String code;

    StatusCategoryEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static StatusCategoryEnum getEnum(String code){
        switch (code){
            case CommonConstant.STATUS_CATEGORY_DEFAULT:
                return DEFAULT;
            default:
                return DELETE;
        }
    }
}
