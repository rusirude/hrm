package com.leaf.hrm.enums;

import com.leaf.hrm.utility.CommonConstant;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public enum DeleteStatusEnum {

    DELETE(CommonConstant.STATUS_CATEGORY_DELETE);


    private String code;

    DeleteStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static DeleteStatusEnum getEnum(String code){
        switch (code){
            case CommonConstant.STATUS_CATEGORY_DELETE:
                return DELETE;
            default:
                return null;
        }
    }
}
