package com.vdlm.utils;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class ImageUtils {
	/**
	 * 缩放图像（按高度和宽度缩放）
	 * 
	 * @param imageByte
	 * @param height
	 *            缩放后的高度
	 * @param width
	 *            缩放后的宽度
	 */
	public final static byte[] reSize(byte[] imageByte, int height, int width,
			String suffix) {
		double ratio = 0.0; // 缩放比例
		byte[] newImageByte = null;
		BufferedImage bi = null;

		try {
			bi = ImageIO.read(new ByteArrayInputStream(imageByte));

			Image itemp = bi.getScaledInstance(width, height,
					BufferedImage.SCALE_SMOOTH);
			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write((BufferedImage) itemp, suffix, out);
			newImageByte = out.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newImageByte;
	}

	/**
	 * 缩放图像（按比例缩放）
	 * 
	 * @param imageByte
	 * @param scale
	 *            缩放比例
	 * @param flag
	 *            缩放选择:true 放大; false 缩小;
	 */
	// public final static void reSize1(byte[] imageByte,
	// int scale, boolean flag) {
	// try {
	// BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
	// int width = src.getWidth(); // 得到源图宽
	// int height = src.getHeight(); // 得到源图长
	// if (flag) {// 放大
	// width = width * scale;
	// height = height * scale;
	// } else {// 缩小
	// width = width / scale;
	// height = height / scale;
	// }
	// Image image = src.getScaledInstance(width, height,
	// Image.SCALE_DEFAULT);
	// BufferedImage tag = new BufferedImage(width, height,
	// BufferedImage.TYPE_INT_RGB);
	// Graphics g = tag.getGraphics();
	// g.drawImage(image, 0, 0, null); // 绘制缩小后的图
	// g.dispose();
	// ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	public static InputStream getImageStream(BufferedImage img) {
		InputStream is = null;
		img.flush();
		ByteArrayOutputStream bs = new ByteArrayOutputStream();

		ImageOutputStream imOut;
		try {
			imOut = ImageIO.createImageOutputStream(bs);

			ImageIO.write(img, "jpg", imOut);

			is = new ByteArrayInputStream(bs.toByteArray());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 生成访问统计图片
	 * 
	 * @param accesses
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage graphicsGeneration(List<Integer> accesses,
			URL imgBgUrl) throws IOException {
		BufferedImage image = null;
		int x_offset = 70; // X轴从底部开始 初始偏移量
		int y_offset = 85; // Y轴从左面开始 初始偏移量
		int x_interval = 20; // 每个小时的Y轴间隔量
		int imageHeight = 295;// 图片的高度
		int y_height = imageHeight - 70 - x_offset; //
		image = ImageIO.read(imgBgUrl);

		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,	RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int y_max = 0, uvMax = 0;
		for (Integer access : accesses) {
			y_max = access > y_max ? access : y_max;
		}
		uvMax = y_max;
		y_max = y_max + y_max % 5;
		graphics.setFont(new Font("Courier New", Font.PLAIN, 18));
		boolean bPoint = false;
		for (int j = 0; j < accesses.size() - 1; j++) {
			Integer access = accesses.get(j);
			Integer nextAcces = accesses.get(j + 1);

			int a = y_height - y_height * access / y_max + x_offset;
			int b = y_height - y_height * nextAcces / y_max + x_offset;
			// x1,y1 开始节点 x2,y2结束节点
			graphics.drawLine(y_offset + x_interval * j, a, y_offset + x_interval * (j + 1), b);

			if (uvMax == access && !bPoint) {
				bPoint = true;
				graphics.drawString(uvMax + "", y_offset + x_interval * j - 5, a - 2);
			}

			// 显示23点为最大值
			if (accesses.size() - 2 == j && !bPoint) {
				graphics.drawString(uvMax + "", y_offset + x_interval * (j + 1)	- 5, b - 2);
			}
		}

		graphics.dispose();
		return image;
	}

	public static void inputstreamToFile(InputStream ins, File file)
			throws IOException {
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		ins.close();
	}
}
