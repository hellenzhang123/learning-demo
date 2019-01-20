package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.ExportData;

public interface ExportService {

	public void exportByPOI(List<ExportData> exportDataList, String[] titles, String titleValue, String fileName, HttpServletResponse response);
}
