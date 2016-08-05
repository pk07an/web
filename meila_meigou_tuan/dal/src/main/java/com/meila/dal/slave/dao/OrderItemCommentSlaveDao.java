package com.meila.dal.slave.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.vdlm.dal.model.OrderItemComment;
import com.vdlm.dal.model.OrderItemCommentImage;

public interface OrderItemCommentSlaveDao {

	Long countByProductId(@Param("productId") String productId);

	List<OrderItemComment> selectByProductId(@Param("productId") String productId, @Param("pager") Pageable pager);

	BigDecimal selectProcuctScoreAvg(@Param("productId") String productId);

	List<OrderItemCommentImage> selectImageByCommentId(@Param("commentId") String commentId);

	OrderItemComment selectLastestNiceCheckByProductId(@Param("productId") String productId);
}
