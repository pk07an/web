package com.vdlm.biz.qiniu;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

import com.qiniu.api.auth.AuthException;
import com.vdlm.biz.vo.UpLoadFileVO;
import com.vdlm.dal.type.FileBelong;

public interface Qiniu {

	static String SPLIT_SYMBOL = "|";

	/**
	 * 根据文件所属，获得空间名
	 * 
	 * @param belong
	 * @return
	 */
	String genBucketName(FileBelong belong);

	/**
	 * 根据空间名获取上传授权凭证
	 * 服务端上传所用
	 * @param bucketName
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 */
	String genUpToken(String bucketName) throws AuthException, JSONException;

	/**
	 * 上传图片
	 * 
	 * @param files
	 * @param bucketName
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 * @throws IOException
	 */
	List<UpLoadFileVO> uploadImg(List<MultipartFile> files, FileBelong belong) throws AuthException,
			JSONException, IOException;
	
	
	/**
	 * 客户端上传，须获取token
	 * @param bucketName
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 */
	String genUpTokenForClient(String bucketName) throws AuthException, JSONException;
	
	/**
	 * 流的方式上传
	 * @param ins
	 * @param belong
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 * @throws IOException
	 */
	List<UpLoadFileVO> uploadImgStream(List<InputStream> ins, FileBelong belong)throws AuthException, JSONException, IOException;
	
	/**
	 * 把七牛的key转换成本地数据库的key
	 * 
	 * @param qiniuKey
	 * @param bucketName
	 * @return
	 */
	String qiniuKeyToLocalKey(String qiniuKey, String bucketName);

	/**
	 * 得到图片的完整url
	 * 
	 * @param localKey
	 * @return
	 */
	String genQiniuFileUrl(String localKey);

}
