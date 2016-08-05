package com.vdlm.dal.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.vdlm.dal.model.promotion.PromotionActionType;

/**
 *
 * @author: chenxi
 */

@Alias("actionTypeHandler")
public class PromotionActionTypeHandler extends BaseTypeHandler<PromotionActionType> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PromotionActionType parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.code());
	}

	@Override
	public PromotionActionType getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		final int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return PromotionActionType.fromCode(i);
        }
	}

	@Override
	public PromotionActionType getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		final int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return PromotionActionType.fromCode(i);
        }
	}

	@Override
	public PromotionActionType getNullableResult(CallableStatement cs,
			int columnIndex) throws SQLException {
		final int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return PromotionActionType.fromCode(i);
        }
	}

}
