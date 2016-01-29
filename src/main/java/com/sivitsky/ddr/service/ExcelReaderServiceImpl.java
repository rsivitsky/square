package com.sivitsky.ddr.service;

import com.sivitsky.ddr.model.Currency;
import com.sivitsky.ddr.model.Offer;
import com.sivitsky.ddr.model.Part;
import com.sivitsky.ddr.model.Vendor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelReaderServiceImpl implements ExcelReaderService {

    private CurrencyService currencyService;
    private OfferService offerService;
    private PartService partService;

    @Autowired(required = true)
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @Autowired(required = true)
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @Autowired(required = true)
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    public void readBooksFromExcelFile(javax.servlet.http.Part offers_file, Vendor vendor) throws IOException {
        InputStream inputStream = offers_file.getInputStream();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        for (Row nextRow : firstSheet) {
            if (nextRow.getRowNum() > 0) {
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Offer offer = new Offer();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 1:
                            offer.setOffer_date(nextCell.getDateCellValue());
                            break;
                        case 2:
                            offer.setOffer_price(Float.parseFloat(getCellValue(nextCell).toString()));
                            break;
                        case 3:
                            try {
                                Currency currency = currencyService.getCurrencyByName(nextCell.getStringCellValue());
                                offer.setCurrency(currency != null ? currency : currencyService.getCurrencyById(1L));
                                break;
                            } catch (NullPointerException e) {
                                offer.setCurrency(currencyService.getCurrencyById(1L));
                                break;
                            }
                        case 4:
                                if (partService.getPartByName(nextCell.getStringCellValue())!=null)
                                {
                                    offer.setPart(partService.getPartByName(nextCell.getStringCellValue()));
                                    break;
                                }
                                else
                                {
                                    Part part = new Part();
                                    part.setPart_name(nextCell.getStringCellValue());
                                    partService.savePart(part);
                                    offer.setPart(part);
                                    break;
                                }
                        case 5:
                            offer.setOffer_num((int) nextCell.getNumericCellValue());
                            break;
                        case 6:
                            offer.setOffer_sum((float)(nextCell.getNumericCellValue()));
                            break;
                    }
                }
                offer.setVendor(vendor);
                offerService.saveOffer(offer);
            }
        }
        workbook.close();
        inputStream.close();
    }

    public Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }
}
