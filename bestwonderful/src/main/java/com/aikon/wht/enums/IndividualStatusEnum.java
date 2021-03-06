package com.aikon.wht.enums;

import lombok.Getter;

/**
 * @author Administrator
 */
public enum IndividualStatusEnum {

    // INVALID
    INVALID(0, "无效"),
    // VALID
    VALID(1, "有效"),
    // LOCKED
    LOCKED(2, "锁定"),
    ;

    IndividualStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Getter Integer code;

    @Getter String desc;
}
