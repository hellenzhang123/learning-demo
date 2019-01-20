package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.ExportData;
import com.example.demo.service.ExportService;

@Controller
public class ExportController {

	@Autowired
	private ExportService easyExportService;

	@RequestMapping(method=RequestMethod.GET, value="exportpoi")
	@ResponseBody
	public void  easyExport(HttpServletResponse response) {
		List<ExportData> exportList = new ArrayList<>();
		ExportData data1 = new ExportData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		ExportData data2 = new ExportData("酸酱男盆友", 23, 1, "深圳福田 ", "44112121345646426", "我是酸酱的男盆友");
		ExportData data3 = new ExportData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		ExportData data4 = new ExportData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		ExportData data5 = new ExportData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		exportList.add(data1);
		exportList.add(data2);
		exportList.add(data3);
		exportList.add(data4);
		exportList.add(data5);
		String[] titles = new String[] {"姓名","年龄","性别","身份证","地址","个人备注"};
		easyExportService.exportByPOI(exportList, titles, "个人信息", "个人信息.xls", response);
	}
}
