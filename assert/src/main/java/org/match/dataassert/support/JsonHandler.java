package org.match.dataassert.support;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


@MappedTypes({Object.class})
public class JsonHandler extends BaseTypeHandler<Object> {

    private static final ObjectMapper mapper = new ObjectMapper();





    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        String json = JSONUtil.toJsonStr(o);
        preparedStatement.setString(i, json);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //转成对象
        if(Objects.nonNull(resultSet.getObject(s))){
            Object parse =  JSONUtil.toJsonStr(resultSet.getObject(s).toString());
            return parse;

        }
        return null;
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        if(Objects.nonNull(resultSet.getObject(i))) {
            Object parse =   JSONUtil.toJsonStr(resultSet.getObject(i).toString());
            return parse;
        }
        return null;
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
