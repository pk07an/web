package com.vdlm.biz.qiniu.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import com.vdlm.biz.qiniu.PutRetExtra;
import com.vdlm.biz.qiniu.Qiniu;
import com.vdlm.biz.res.ResourceFacade;
import com.vdlm.biz.vo.UpLoadFileVO;
import com.vdlm.dal.type.FileBelong;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;

@Component("qiniu")
@Profile({ "dev", "test" })
public class QiniuNonProdImpl implements Qiniu {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	class QiniuBean {
		public String bucketType;
		public String bucketName;
		public String siteHost;
		public String accessKey;
		public String secretKey;

		public QiniuBean(String bucketType, String bucketName, String siteHost,
				String accessKey, String secretKey) {
			this.bucketType = bucketType;
			this.bucketName = bucketName;
			this.siteHost = siteHost;
			this.accessKey = accessKey;
			this.secretKey = secretKey;
		}
		
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}

	Map<String, QiniuBean> mapQiniuBean = null;

	@Value("${qiniu.product}")
	String qiniuProduct;
//
//	@Value("${qiniu.shop}")
//	String qiniuShop;
//
//	@Value("${qiniu.stat}")
//	String qiniuStat;
//
//	@Value("${qiniu.resource}")
//	String qiniuResource;
//
//	@Value("${qiniu.log}")
//	String qiniuLog;
//	
//	@Value("${qiniu.other}")
//	String qiniuOther;
//	
//	@Value("${qiniu.extfmt}")
//	String qiniuExtFmt;
//
//	@Value("${qiniu.query.product}")
//	String qiniuQueryProduct;
//
//	@Value("${qiniu.query.shop}")
//	String qiniuQueryShop;
//
//	@Value("${qiniu.query.stat}")
//	String qiniuQueryStat;
//
//	@Value("${qiniu.query.resource}")
//	String qiniuQueryResource;
//
//	@Value("${qiniu.query.log}")
//	String qiniuQueryLog;
//	
//	@Value("${qiniu.query.other}")
//	String qiniuQueryOther;
	
	@Value("${qiniu.bucketName}")
	String qiniuBucketName;
	
	protected QiniuBean findQueryQiniuBeanByBucketName(String bucketName) {
		initMapQiniuBean();
		return mapQiniuBean.get(bucketName);
	}
	
	protected QiniuBean findQiniuBeanByBucketName(String bucketName) {
		initMapQiniuBean();
		QiniuBean bean = mapQiniuBean.get(bucketName);
		if(bean == null){
			log.info("bucketName = [" + bucketName + "]");
			log.info(mapQiniuBean.toString());
			throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "bucket错误");
		}
		return bean;
	}

	protected synchronized void initMapQiniuBean() {
		if (mapQiniuBean != null)
			return;

		mapQiniuBean = new HashMap<String, QiniuBean>();
		String[] products = qiniuProduct.split("\\|");
		QiniuBean bean = new QiniuBean("product", products[0], products[1],
				products[2], products[3]);
		mapQiniuBean.put(products[0], bean);

//		String[] shops = qiniuShop.split("\\|");
//		bean = new QiniuBean("shop", shops[0], shops[1], shops[2], shops[3]);
//		mapQiniuBean.put(shops[0], bean);
//
//		String[] stats = qiniuStat.split("\\|");
//		bean = new QiniuBean("stat", stats[0], stats[1], stats[2], stats[3]);
//		mapQiniuBean.put(stats[0], bean);
//
//		String[] resources = qiniuResource.split("\\|");
//		bean = new QiniuBean("resource", resources[0], resources[1],
//				resources[2], resources[3]);
//		mapQiniuBean.put(resources[0], bean);
//
//		String[] logs = qiniuLog.split("\\|");
//		bean = new QiniuBean("log", logs[0], logs[1], logs[2], logs[3]);
//		mapQiniuBean.put(logs[0], bean);
//		
//		String[] others = qiniuOther.split("\\|");
//		bean = new QiniuBean("other", others[0], others[1], others[2], others[3]);
//		mapQiniuBean.put(others[0], bean);
//		
//		//测试数据库导入正式数据库，兼容图片
//				if(StringUtils.isNotBlank(qiniuQueryProduct)){
//					String[] productQuerys = qiniuQueryProduct.split("\\|");
//					bean = new QiniuBean("productQuery", productQuerys[0], productQuerys[1], productQuerys[2], productQuerys[3]);
//					mapQiniuBean.put(productQuerys[0], bean);
//				}
//				
//				if(StringUtils.isNotBlank(qiniuQueryShop)){
//					String[] shopQuerys = qiniuQueryShop.split("\\|");
//					bean = new QiniuBean("shopQuery", shopQuerys[0], shopQuerys[1], shopQuerys[2], shopQuerys[3]);
//					mapQiniuBean.put(shopQuerys[0], bean);
//				}
//				
//				if(StringUtils.isNotBlank(qiniuQueryResource)){
//					String[] resourceQuerys = qiniuQueryResource.split("\\|");
//					bean = new QiniuBean("resourceQuery", resourceQuerys[0], resourceQuerys[1], resourceQuerys[2], resourceQuerys[3]);
//					mapQiniuBean.put(resourceQuerys[0], bean);
//				}
//				
//				if(StringUtils.isNotBlank(qiniuQueryOther)){
//					String[] otherQuerys = qiniuQueryOther.split("\\|");
//					bean = new QiniuBean("otherQuery", otherQuerys[0], otherQuerys[1], otherQuerys[2], otherQuerys[3]);
//					mapQiniuBean.put(otherQuerys[0], bean);
//				}
	}

	@Override
	public String genUpToken(String bucketName) throws AuthException,
			JSONException {
		QiniuBean bean = findQiniuBeanByBucketName(bucketName);
//		Config.ACCESS_KEY = bean.accessKey;
//		Config.SECRET_KEY = bean.secretKey;
		Mac mac = new Mac(bean.accessKey, bean.secretKey);

		PutPolicy putPolicy = new PutPolicy(bucketName);
		String returnBody = "{key: $(key), name:$(fname), size: $(fsize), w: $(imageInfo.width),"
				+ "h: $(imageInfo.height), hash: $(etag), suffix:$(suffix), imageAve:$(imageAve) }";
		putPolicy.returnBody = returnBody;
		String uptoken = putPolicy.token(mac);
		return uptoken;
	}

	/**
	 * 上传文件，如果上传失败，则返回一个空的List
	 */
	@Override
	public List<UpLoadFileVO> uploadImg(List<MultipartFile> files,
			FileBelong belong) throws AuthException, JSONException, IOException {

		List<InputStream> ins = new ArrayList<InputStream>();
		for (MultipartFile file : files) {
			ins.add(file.getInputStream());
		}
		return uploadImgStream(ins, belong);
	}

	@Override
	public List<UpLoadFileVO> uploadImgStream(List<InputStream> ins,
			FileBelong belong) throws AuthException, JSONException, IOException {
		String bucketName = genBucketName(belong);
		String uptoken = genUpToken(bucketName);

		List<UpLoadFileVO> vos = new ArrayList<UpLoadFileVO>();
		PutExtra extra = new PutExtra();
		PutRet ret = null;
		UpLoadFileVO vo = null;
		PutRetExtra retEx = null;
		for (InputStream in : ins) {
			ret = IoApi.Put(uptoken, null, in, extra);
			if (StringUtils.isNotBlank(ret.getKey())) {
				retEx = new PutRetExtra(ret.getResponse());
				vo = new UpLoadFileVO();
				vo.setKey(ret.getKey());
//				vo.setKey(qiniuKeyToLocalKey(ret.getKey(), bucketName));
				vo.setId(vo.getKey());
				vo.setHeight(retEx.getHeight());
				vo.setWidth(retEx.getWidth());
				vo.setSize(retEx.getSize());
				vo.setSuffix(retEx.getSuffix());
				vo.setImageAve(retEx.getImageAve());
				vos.add(vo);
			}
		}
		return vos;
	}

	@Override
	public String genBucketName(FileBelong belong) {
//		initMapQiniuBean();
//		String bucketName = null;
//		String bucketType = null;
//
//		switch (belong) {
//		case PRODUCT:
//			bucketType = "product";
//			break;
//		case SHOP:
//			bucketType = "shop";
//			break;
//		case STAT:
//			bucketType = "stat";
//			break;
//		case RESOURCE:
//			bucketType = "resource";
//			break;
//		case LOG:
//			bucketType = "log";
//			break;
//		case OTHER:
//			bucketType = "other";
//			break;			
//		default:
//			break;
//
//		}
//		for (String key : mapQiniuBean.keySet()) {
//			QiniuBean bean = mapQiniuBean.get(key);
//			if (bean.bucketType.equals(bucketType)) {
//				bucketName = bean.bucketName;
//				break;
//			}
//		}
//
//		return bucketName;
		return qiniuBucketName;
	}

	/**
	 * 七牛返回的文件key转为本地保存到数据中的key
	 */
	@Override
	public String qiniuKeyToLocalKey(String qiniuKey, String bucketName) {
		log.debug("QiniuNonProdImpl#qiniuKeyToLocalKey  qiniuKey : " + qiniuKey +  " \t bucketName: " + bucketName );
		return ResourceFacade.FILE_STORE_KEY_V2 + bucketName + SPLIT_SYMBOL
				+ qiniuKey;
	}

	/**
	 * 根据本地数据库中保存的key，转换成图片url
	 */
	@Override
	public String genQiniuFileUrl(String localKey) {
		log.debug("QiniuNonProdImpl#qiniuKeyToLocalKey  localKey : " + localKey  );
		String[] keys = localKey.split("\\|");
		if (keys.length < 3) {
			return "";
		}

		String bucketName = keys[1];
		String qiniuKey = keys[2];
		QiniuBean bean = findQiniuBeanByBucketName(bucketName);

		String sytle = convert2QiniuStyle(keys.length > 3 ? keys[3] : "");
		return bean.siteHost + "/" + qiniuKey + sytle;
	}

	protected String convert2QiniuStyle(String localStyle) {
		String qiuiuStyle = null;
		int maxWidth = 480;
		// 大括号包围的表示
		if (Pattern.matches("\\{(.+?)\\}", localStyle)) {
			JSONObject jsonObj;
			try {
				jsonObj = new JSONObject(localStyle);
				int width = jsonObj.optInt("w", maxWidth);
				int height = jsonObj.optInt("h", 0);
				int quality = jsonObj.optInt("q", 100);
				int mode = jsonObj.optString("m", "cut").equals("cut") ? 1 : 2;
				qiuiuStyle = "?imageView2/" + mode + "/w/" + width + "/q/" + quality;
				if (height > 0)
					qiuiuStyle += "/h/" + height;
				//qiuiuStyle += qiniuExtFmt;
			} catch (JSONException e) {
				throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "图片参数错误");
			}

		} else { //支持老的方式
			if (ResourceFacade.IMAGE_S1.equals(localStyle)) {
				qiuiuStyle = "?imageView2/2/w/" + maxWidth;
			} else if (ResourceFacade.IMAGE_S03.equals(localStyle)) {
				qiuiuStyle = "?imageView2/2/w/" + (int) (maxWidth * 0.3);
			} else if (ResourceFacade.IMAGE_S05.equals(localStyle)) {
				qiuiuStyle = "?imageView2/2/w/" + (int) (maxWidth * 0.5);
			} else if (ResourceFacade.IMAGE_S025.equals(localStyle)) {
				qiuiuStyle = "?imageView2/2/w/" + (int) (maxWidth * 0.25);
			} else {
				qiuiuStyle = "?imageView2/2/w/" + maxWidth;
			}
			//qiuiuStyle += "/q/100" + qiniuExtFmt;
			qiuiuStyle += "/q/100";
		}
		return qiuiuStyle;
	}

	@Override
	public String genUpTokenForClient(String bucketName) throws AuthException,
			JSONException {
		QiniuBean bean = findQiniuBeanByBucketName(bucketName);
//		Config.ACCESS_KEY = bean.accessKey;
//		Config.SECRET_KEY = bean.secretKey;
		Mac mac = new Mac(bean.accessKey, bean.secretKey);

		PutPolicy putPolicy = new PutPolicy(bucketName);
		String uptoken = putPolicy.token(mac);
		return uptoken;
	}
}
