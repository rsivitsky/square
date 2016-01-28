package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Offer;
import com.sivitsky.ddr.model.Vendor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public interface ExcelReaderService {
    Object getCellValue(Cell cell);
    void readBooksFromExcelFile(javax.servlet.http.Part offers_file, Vendor vendor) throws IOException;
    Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException;
}
