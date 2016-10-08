package com.demo.common.enums.handler;

import com.demo.common.enums.UserStatus;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.MappedTypes;

/**
 * Created by jie_r on 2016/9/25.
 */
@MappedTypes({com.demo.common.enums.UserStatus.class})
public class UserStatusEnumOrdinalTypeHandler extends EnumOrdinalTypeHandler<UserStatus> {
    public UserStatusEnumOrdinalTypeHandler(Class<UserStatus> type) {
        super(type);
    }
}
