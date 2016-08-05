package com.vdlm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.record.formula.functions.Cell;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java操作Excel封装
 * 
 * @author charon
 * 
 */
public class ExcelUtils {

	private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

	/**
	 * 导出Excle文档
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param objClass
	 *            : Excel数据源中的数据类型
	 * @param sheetTitle
	 *            : 新建Sheet的名称 ex: title = "员工表";
	 * @param secondTitle
	 *            : Sheet各列的标题（第一行各列的名称） ex: strTitle =
	 *            "员工代码,员工姓名,性别,出生日期,籍贯,所属机构,联系电话,电子邮件,助记码";
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称） ex: strBody =
	 *            "getCode,getName,getSex,getBirthday,getHomeplace.getName,getOrg.getShortName,getContactTel,getEmail,getZjm"
	 *            ;
	 * @param outputPath
	 *            : Excel文档保存路径
	 */
	public static void exportExcelByObject(List objList, Class objClass,
			String sheetTitle, String firstTitle, String[] secondTitle,
			String[] strBody, String outputPath) {
		// 初始化工作簿
		HSSFWorkbook workbook = initWorkbook(objList, objClass, sheetTitle,
				firstTitle, secondTitle, strBody);
		// 保存Excel文件
		saveExcelFile(workbook, outputPath);
	}

	/**
	 * 初始化工作簿
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param objClass
	 *            : Excel数据源中的数据类型
	 * @param sheetTitle
	 *            : 新建Sheet的名称
	 * @param secondTitle
	 *            : Sheet各列的标题（第一行各列的名称）
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称）
	 */
	private static HSSFWorkbook initWorkbook(List objList, Class objClass,
			String sheetTitle, String firstTitle, String[] secondTitle,
			String[] strBody) {
		// 创建工作簿（Excel文件）
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 创建Excel工作簿的第一个Sheet页
		HSSFSheet sheet = workbook.createSheet(sheetTitle);

		// 创建Sheet页的文件头（第一行）
		createFirstTitle(workbook, sheet, firstTitle);

		// 创建Sheet页的文件头（第一行）
		createSecondTitle(workbook, sheet, secondTitle);

		// 创建Sheet页的文件体（后续行）
		createBody(workbook, objList, objClass, sheet, strBody);

		sheet.addMergedRegion(new Region(0, (short) 0, 0,
				(short) (strBody.length + 1)));

		return workbook;
	}

	private static HSSFCellStyle createFirstTitleStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); //填充单元格
		// cellStyle.setFillForegroundColor(HSSFColor.AUTOMATIC.index); //填暗红色
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 24); // 字体大小
		font.setFontName("楷体");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 粗体
		font.setColor(HSSFColor.BLACK.index); // 颜色
		cellStyle.setFont(font);
		return cellStyle;
	}

	private static HSSFCellStyle createSecondTitleStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); //填充单元格
		// cellStyle.setFillForegroundColor(HSSFColor.AUTOMATIC.index); //填暗红色
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 20); // 字体大小
		// font.setFontName("楷体");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 粗体
		font.setColor(HSSFColor.BLACK.index); // 颜色
		cellStyle.setFont(font);
		return cellStyle;
	}

	/**
	 * 创建Excel当前sheet页的头信息
	 * 
	 * @param sheet
	 *            : Excel工作簿的一个sheet
	 * @param strTitle
	 *            : sheet头信息列表(sheet第一行各列值)
	 */
	private static void createFirstTitle(HSSFWorkbook workbook,
			HSSFSheet sheet, String strTitle) {
		HSSFRow row = sheet.createRow(0); // 创建该页的一行
		row.setHeight((short) 640);

		HSSFCell cell1 = row.createCell((short) 0); // 创建该行的一列
		cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
		HSSFRichTextString value = new HSSFRichTextString(strTitle);
		cell1.setCellValue(value);
		cell1.setCellStyle(createFirstTitleStyle(workbook));
	}

	/**
	 * 创建Excel当前sheet页的头信息
	 * 
	 * @param sheet
	 *            : Excel工作簿的一个sheet
	 * @param strTitle
	 *            : sheet头信息列表(sheet第一行各列值)
	 */
	private static void createSecondTitle(HSSFWorkbook workbook,
			HSSFSheet sheet, String[] strTitle) {
		HSSFRow row = sheet.createRow(1); // 创建该页的一行
		HSSFCell cell = null;
		for (short i = 0; i < strTitle.length; i++) {
			cell = row.createCell(i); // 创建该行的一列
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			HSSFRichTextString value = new HSSFRichTextString(strTitle[i]);
			cell.setCellValue(value);
			cell.setCellStyle(createSecondTitleStyle(workbook));
			sheet.setColumnWidth((short)i,(short)5120);
		}

	}

	/**
	 * 创建Excel当前sheet页的体信息
	 * 
	 * @param objList
	 *            : Excel数据源
	 * @param objClass
	 *            : Excel数据源中的数据类型
	 * @param sheet
	 *            : Excel工作簿的sheet页
	 * @param strBody
	 *            : Sheet各列的取值方法名（各列的值在objClass中get方法名称）
	 */
	private static void createBody(HSSFWorkbook workbook, List objList, Class objClass,
			HSSFSheet sheet, String[] targetMethod) {
		Method[] ms = objClass.getMethods();
		// 循环objList对象列表（生成sheet的行）
		for (int objIndex = 0; objIndex < objList.size(); objIndex++) {
			Object obj = objList.get(objIndex);
			HSSFRow row = sheet.createRow(objIndex + 2);
			// 循环strBody目标方法数组（生成sheet的列）
			for (short strIndex = 0; strIndex < targetMethod.length; strIndex++) {
				String targetMethodName = targetMethod[strIndex];
				// 循环ms方法数组，找到目标方法（strBody中指定的方法）并调用
				for (int i = 0; i < ms.length; i++) {
					Method srcMethod = ms[i];
					int len = targetMethodName.indexOf(".") < 0 ? targetMethodName
							.length() : targetMethodName.indexOf(".");
					if (srcMethod.getName().equals(
							targetMethodName.substring(0, len))) {
						HSSFCell cell = row.createCell(strIndex);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						try {
							// 如果方法返回一个引用类型的值
							Object valueObj = null;
							if (targetMethodName.contains(".")) {
								valueObj = referenceInvoke(targetMethodName, obj);
							} else {
								valueObj = srcMethod.invoke(obj);
							}
							HSSFRichTextString value = null;
							if (valueObj == null) {
								value = new HSSFRichTextString("");
							} else {
								if(valueObj instanceof BigDecimal){
									HSSFCellStyle cellStyle = workbook.createCellStyle();
									cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
									cell.setCellStyle(cellStyle);
								}
								value = new HSSFRichTextString((valueObj.toString()));
							}
							cell.setCellValue(value);
						} catch (Exception e) {
							log.debug("反射获取对象值异常:", e);
						}
					}
				}
			}
		}

	}

	/**
	 * 方法返回的是一个对象的引用（如：getHomeplace.getName类型的方法序列） 按方法序列逐层调用直到最后放回基本类型的值
	 * 
	 * @param targetMethod
	 *            : obj对象所包含的方法列
	 * @param obj
	 *            : 待处理的对象
	 * @return
	 */
	// getHomeplace.getName emp(obj)
	private static Object referenceInvoke(String targetMethod, Object obj) {
		// 截取方法序列的第一个方法(即截取属于obj对象的方法：getHomeplace())
		String refMethod = targetMethod.substring(0, targetMethod.indexOf("."));
		// 获得后续方法序列(getName())
		targetMethod = targetMethod.substring(targetMethod.indexOf(".") + 1);
		try {
			// 获得第一个方法的执行结果(即obj方法执行的结果：obj.getHomeplace())
			obj = obj.getClass().getMethod(refMethod).invoke(obj);
		} catch (Exception e) {
			log.debug("反射获取对象值异常:", e);
		}

		// 如果方法序列没到最后一节
		if (targetMethod.contains(".")) {
			return referenceInvoke(targetMethod, obj);
			// 如果方法序列到达最后一节
		} else {
			try {
				// 通过obj对象获得该方法链的最后一个方法并调用
				Method tarMethod = obj.getClass().getMethod(targetMethod);
				if (tarMethod.invoke(obj) == null) {
					return null;
				}
				return tarMethod.invoke(obj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

	/**
	 * 保存Excel文件
	 * 
	 * @param workbook
	 *            : Excel工作簿
	 * @param outputPath
	 *            : Excel文件保存路径
	 */
	private static void saveExcelFile(HSSFWorkbook workbook, String outputPath) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputPath);
			workbook.write(fos);

			fos.flush();
			fos.close();
		} catch (IOException e) {
			log.debug("文件操作异常:", e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					log.debug("关闭流文件异常:", e);
				}
			}
		}
	}
	/**
	 * 读取excel转换为Java List对象
	 * @param is 文件流
	 * @return
	 */
	public static List<String[]> excelImport(InputStream is){
		List<String[]> list=new ArrayList<String[]>();
		try{
			POIFSFileSystem fs = new POIFSFileSystem(is);
			HSSFWorkbook  wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			int rowNum=sheet.getLastRowNum();
			//读取值
			for(int i = 0; i <= rowNum; i++){
				HSSFRow row=sheet.getRow(0);
				int colNum=row.getPhysicalNumberOfCells();
				HSSFRow r=sheet.getRow(i);
				String[] cols=new String[colNum];
				for(int j=0;j<colNum;j++){
					HSSFCell c=r.getCell(j);
					cols[j]=getCellFormatValue(c);
				}
				list.add(cols);
			}
			
		}catch(Exception e){
			log.debug("读取excel异常",e);
		}
		return list;
	} 
	
	 private static String getCellFormatValue(HSSFCell cell) {
	        String cellvalue = "";
	        if (cell != null) {
	            // 判断当前Cell的Type
	            switch (cell.getCellType()) {
	            // 如果当前Cell的Type为NUMERIC
	            case HSSFCell.CELL_TYPE_NUMERIC:
	            case HSSFCell.CELL_TYPE_FORMULA: {
	                // 判断当前的cell是否为Date
	                if (HSSFDateUtil.isCellDateFormatted(cell)) {
	                    // 如果是Date类型则，转化为Data格式
	                    
	                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
	                    //cellvalue = cell.getDateCellValue().toLocaleString();
	                    
	                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
	                    Date date = cell.getDateCellValue();
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    cellvalue = sdf.format(date);
	                }
	                // 如果是纯数字
	                else {
	                    // 取得当前Cell的数值
	                    cellvalue = String.valueOf(cell.getNumericCellValue());
	                }
	                break;
	            }
	            // 如果当前Cell的Type为STRIN
	            case HSSFCell.CELL_TYPE_STRING:
	                // 取得当前的Cell字符串
	                cellvalue = cell.getRichStringCellValue().getString();
	                break;
	            // 默认的Cell值
	            default:
	                cellvalue = " ";
	            }
	        } else {
	            cellvalue = "";
	        }
	        return cellvalue;

	    }



    /**
     *  解析流程中excel文件,业务逻辑函数请在上面新增方法
     *  by reese 2015-7-30
     * @param stream
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getDataFromFile(InputStream stream) throws Exception {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        //获取一个特定的工作薄
        try {
            POIFSFileSystem fs = new POIFSFileSystem(stream);
            HSSFWorkbook workbook = new HSSFWorkbook(fs);
//            for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
//                HSSFSheet sheet = workbook.getSheetAt(numSheets);
                HSSFSheet sheet = workbook.getSheetAt(0);
//                if (sheet == null) {
//                    continue;
//                }

                // 循环每一行
                for (int rowNum = 1; rowNum <= sheet.getPhysicalNumberOfRows()-1; rowNum++) {
                    HSSFRow aRow = sheet.getRow(rowNum);
                    if (null == aRow || aRow.getCell(0) == null || aRow.getCell(0).getRichStringCellValue() == null || StringUtils.isBlank(aRow.getCell(0).getRichStringCellValue().toString())) {
                        break;
                    }
                    Map<String, String> datum = new HashMap<String, String>();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    // 循环特定行的每一列
//                    for (short cellNum = 0; cellNum < aRow.getLastCellNum(); cellNum++) {
                    for (short cellNum = 0; cellNum < aRow.getPhysicalNumberOfCells(); cellNum++) {//不为空的所有列循环
                        // 得到特定单元格
                        HSSFCell aCell = aRow.getCell(cellNum);
                        if (aCell == null) {
                            continue;
                        }
                        String cellValue = "";
                        if (0 == aCell.getCellType() && HSSFDateUtil.isCellDateFormatted(aCell)) {
                            cellValue = simpleDateFormat.format(aCell.getDateCellValue());
                        } else if (HSSFCell.CELL_TYPE_NUMERIC == aCell.getCellType()) {
                            cellValue = aCell.getNumericCellValue() + "";
                        } else {
                            aCell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            cellValue = (aCell == null ? null : aCell.getRichStringCellValue().toString());
                        }
                        datum.put(cellNum==0?"orderNo":"buyerId" + "", cellValue.trim());
                    }
                    data.add(datum);
                }
//            }
            if (stream != null) {
                stream.close();
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            if (stream != null) {
                stream.close();
            }
            throw e;
        }
    }
}
