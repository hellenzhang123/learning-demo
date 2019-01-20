package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.ExportEasyData;
import com.example.demo.service.EasyPOIExportSerivce;

@Controller
public class ExportEasyPOIController {

	@Autowired
	private EasyPOIExportSerivce easyExportService;

	@RequestMapping(method=RequestMethod.GET, value="export")
	@ResponseBody
	public void  easyExport(HttpServletResponse response) {
		List<ExportEasyData> exportList = new ArrayList<>();
		ExportEasyData data1 = new ExportEasyData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		ExportEasyData data2 = new ExportEasyData("酸酱男盆友", 23, 1, "深圳福田 ", "44112121345646426", "我是酸酱的男盆友");
		ExportEasyData data3 = new ExportEasyData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		ExportEasyData data4 = new ExportEasyData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		ExportEasyData data5 = new ExportEasyData("酸酱1", 21, 2, "深圳福田 ", "44112121345646456", "我是酸酱1");
		exportList.add(data1);
		exportList.add(data2);
		exportList.add(data3);
		exportList.add(data4);
		exportList.add(data5);
		easyExportService.exportExcel(exportList,"个人信息","个人信息表",ExportEasyData.class,"个人信息表.xls",response);
	}
}
