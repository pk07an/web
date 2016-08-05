package com.vdlm.dal.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.vdlm.dal.model.ObjectRange;

/**
 *
 * @author: chenxi
 */

@Alias("objectRangeHandler")
public class ObjectRangeHandler extends BaseTypeHandler<ObjectRange> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			ObjectRange parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.code());
	}

	@Override
	public ObjectRange getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		final int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return ObjectRange.fromCode(i);
        }
	}

	@Override
	public ObjectRange getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		final int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return ObjectRange.fromCode(i);
        }
	}

	@Override
	public ObjectRange getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		final int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return ObjectRange.fromCode(i);
        }
	}

}
