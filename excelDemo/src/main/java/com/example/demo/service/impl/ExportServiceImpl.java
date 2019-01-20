package com.example.demo.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ExportData;
import com.example.demo.service.ExportService;

@Service
public class ExportServiceImpl implements ExportService {

	@Override
	public void exportByPOI(List<ExportData> exportDataList, String[] titles, String titleValue, String fileName, HttpServletResponse response) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建sheet页
		Sheet sheet = workbook.createSheet();
		// 字体
		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 20);// 字号
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 加粗

		// 头背景色
		XSSFCellStyle styleTitle = workbook.createCellStyle();
		styleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		styleTitle.setFont(font);
		// 创建标题
		Row row = sheet.createRow(0);
		row.setHeightInPoints(30);
		// 设置excel头
		Cell cell = row.createCell(0);
		cell.setCellValue(titleValue);
		cell.setCellStyle(styleTitle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titles.length - 1));
		Row rowTitle = sheet.createRow(1);
		// 设置列头
				XSSFCellStyle styleHeader = workbook.createCellStyle();
				styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
				// 字体
				XSSFFont fontTitle = workbook.createFont();
				fontTitle.setFontHeightInPoints((short) 12);// 字号
				fontTitle.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);// 加粗
				styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
				styleHeader.setFont(fontTitle);
		// 创建标题行
				for (int i = 0; i < titles.length; i++) {
					cell = rowTitle.createCell(i);
					cell.setCellValue(titles[i]);
					cell.setCellStyle(styleHeader);
					sheet.autoSizeColumn((short) i);
				}
				// 创建内容
				for (int i = 0; i < exportDataList.size(); i++) {
					Row rowData = sheet.createRow(1 + i);
					// 此处的6是实体类中的属性个数
						// 将内容按顺序赋给对应的列对象
						rowData.createCell(0).setCellValue(exportDataList.get(i).getName());
						rowData.createCell(1).setCellValue(exportDataList.get(i).getAge());
						rowData.createCell(2).setCellValue(exportDataList.get(i).getGender());
						rowData.createCell(3).setCellValue(exportDataList.get(i).getIdCard());
						rowData.createCell(4).setCellValue(exportDataList.get(i).getAddress());
						rowData.createCell(5).setCellValue(exportDataList.get(i).getRemarks());
				}
				for (int k = 0; k < titles.length; k++) {
					sheet.autoSizeColumn((short) k);
				}
	            try {
	            	response.setContentType("application/octet-stream");
	                // 设置下载文件名
	                response.addHeader("Content-Disposition",
	                    "attachment; filename=\"" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString()) + "\"");
					 workbook.write(response.getOutputStream());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
	}

	/**
	 * excel表格自适应调整列宽，提供中文支持
	 * 
	 * @param sheet
	 * @param size
	 */
	private void setSizeColumn(Sheet sheet, int size) {
		for (int columnNum = 0; columnNum < size; columnNum++) {
			int columnWidth = sheet.getColumnWidth(columnNum) / 256;
			for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
				Row currentRow;
				// 当前行未被使用过
				if (sheet.getRow(rowNum) == null) {
					currentRow = sheet.createRow(rowNum);
				} else {
					currentRow = sheet.getRow(rowNum);
				}

				if (currentRow.getCell(columnNum) != null) {
					Cell currentCell = currentRow.getCell(columnNum);
					if (currentCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
						int length = currentCell.getStringCellValue().getBytes().length;
						if (columnWidth < length) {
							columnWidth = length;
						}
					}
				}
			}
			sheet.setColumnWidth(columnNum, columnWidth * 256);
		}
	}
}
