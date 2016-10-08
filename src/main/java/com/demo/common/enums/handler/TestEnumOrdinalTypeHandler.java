package com.demo.common.enums.handler;

import com.demo.common.enums.Test;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.MappedTypes;

/**
 * Created by jie_r on 2016/9/25.
 */
@MappedTypes({com.demo.common.enums.Test.class})
public class TestEnumOrdinalTypeHandler extends EnumOrdinalTypeHandler<Test> {
    public TestEnumOrdinalTypeHandler(Class<Test> type) {
        super(type);
    }
}
