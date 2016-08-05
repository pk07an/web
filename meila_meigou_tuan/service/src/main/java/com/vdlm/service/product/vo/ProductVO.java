package com.vdlm.service.product.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.model.Product;
import com.vdlm.dal.model.Sku;
import com.vdlm.dal.model.Tag;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;
import com.vdlm.dal.vo.CategoryVO;
import com.vdlm.dal.vo.FragmentVO;
import com.vdlm.dal.vo.OrderItemCommentVO;

/**
 * 用于展现单个商品详情
 * 
 * @author jamesp
 */
@SuppressWarnings("serial")
public class ProductVO extends Product {

	private List<Sku> skus;

	private List<SkuMappingVO> skuMappings;

	private List<Tag> tags;

	private CategoryVO category;

	private List<ProductImageVO> imgs;

	private List<Product> relateds = null;

	@JsonSerialize(using = JsonResourceUrlSerializer.class)
	private String imgUrl;

	private String url;

	private BigDecimal commission;

	private String directCartUrl;

	private List<FragmentVO> fragments;

	private List<OrderItemCommentVO> comments;

	private Long commentsCount;

	private BigDecimal productScore;
	private Map<String, Object> map;// 扩展属性
	// add by luojy 20150703
	private List<String> mainImgs;
	
	private String statusStr;

	public BigDecimal getProductScore() {
		return productScore;
	}

	public void setProductScore(BigDecimal productScore) {
		this.productScore = productScore;
	}

	// 供json转java使用
	public ProductVO() {

	}

	public ProductVO(Product product) {
		BeanUtils.copyProperties(product, this);
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<SkuMappingVO> getSkuMappings() {
		return skuMappings;
	}

	public void setSkuMappings(List<SkuMappingVO> skuMappings) {
		this.skuMappings = skuMappings;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

	public List<ProductImageVO> getImgs() {
		return imgs;
	}

	public void setImgs(List<ProductImageVO> imgs) {
		this.imgs = imgs;
	}

	public List<Product> getRelateds() {
		return relateds;
	}

	public void setRelateds(List<Product> relateds) {
		this.relateds = relateds;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public CategoryVO getCategory() {
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public String getDirectCartUrl() {
		return directCartUrl;
	}

	public void setDirectCartUrl(String directCartUrl) {
		this.directCartUrl = directCartUrl;
	}

	public List<FragmentVO> getFragments() {
		return fragments;
	}

	public void setFragments(List<FragmentVO> fragments) {
		this.fragments = fragments;
	}

	public List<OrderItemCommentVO> getComments() {
		return comments;
	}

	public void setComments(List<OrderItemCommentVO> comments) {
		this.comments = comments;
	}

	public Long getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Long commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	// add by luojy 20150703
	public void setMainImgs(List<String> mainImgs) {
		this.mainImgs = mainImgs;
	}

	public List<String> getMainImgs() {
		return mainImgs;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
}
