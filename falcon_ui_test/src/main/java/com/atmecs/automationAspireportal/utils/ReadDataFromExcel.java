package com.atmecs.automationAspireportal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.atmecs.falcon.automation.ui.selenium.Browser;

public class ReadDataFromExcel {
	private Workbook workBook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	private String cellValue;
	public String path = null;
	private FileInputStream fileInputStream = null;
	private FileOutputStream fileOutputStream = null;
	private String fileExtensionName;

	public void setPath(String path) throws IOException {
		this.path = path;
		verifyExcelWorkBook(path);
	}

	public void verifyExcelWorkBook(String filePath) throws IOException {
		try {
			File file = new File(filePath);
			fileInputStream = new FileInputStream(file);
			fileExtensionName = FilenameUtils.getExtension(filePath);
			if (fileExtensionName.equals("xlsx")) {
				workBook = new XSSFWorkbook(fileInputStream);
			} else if (fileExtensionName.equals("xls")) {
				workBook = new HSSFWorkbook(fileInputStream);
			}
			fileInputStream.close();
		} catch (FileNotFoundException fileNotFoundException) {

			throw new FileNotFoundException("File doesn't exist in the given path: " + filePath);
		} catch (IOException ioException) {

			throw new IOException("File doesn't close properly: " + ioException.getMessage());
		}
	}

	public String getCellDataByColumnName(String sheetname, String columnName, String string2) {
		int columnIndex = -1;
		try {
			int index = workBook.getSheetIndex(sheetname);
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
					columnIndex = i;
				}
			}
			if (columnIndex == -1) {
				return "Column doesn't exist with given name " + columnName;
			}
			String rowI = findRow(sheet, string2);
			int rowInd = Integer.parseInt(rowI);
			return verifyCellData(rowInd, columnIndex);
		} catch (Exception exception) {

			return "row " + string2 + " or column " + columnIndex + " does not exist  in xlsx";
		}
	}

	public String setCellData(String sheetName, String colName, int rowNum, String value) {

		try {
			int col_Num = -1;
			sheet = workBook.getSheet(sheetName);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					col_Num = i;
				}
			}
			if (col_Num == -1) {
				return "Column doesn't exist with given name " + colName;
			}
			sheet.autoSizeColumn(col_Num);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);

			cell = row.getCell(col_Num);
			if (cell == null)
				cell = row.createCell(col_Num);

			cell.setCellValue(value);

			fileOutputStream = new FileOutputStream(path);
			workBook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return value;
	}

	/*
	 * public Filters getFiltersData(Browser browser) { HashMap<String, String> map
	 * = new HashMap<String, String>(); map.put(fileExtensionName, path); return
	 * null; }
	 */

	private String findRow(Sheet sheet, String string2) {
		for (Row row : sheet)
			for (Cell cell : row)
				if (cell.getCellTypeEnum() == CellType.STRING)
					if (cell.getRichStringCellValue().getString().trim().equals(string2)) {
						return row.getRowNum() + "";
					}
		return sheet + " doesn't exist with given name " + string2;
	}

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			sheet = workBook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}

	private String verifyCellData(int rowIndex, int columnIndex) {
		row = sheet.getRow(rowIndex);
		if (row == null) {
			return "Data doesn't exist in given row";
		}
		cell = row.getCell(columnIndex);
		if (cell == null) {
			return "Data doesn't exist in given cell";
		}
		switch (cell.getCellTypeEnum()) {
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case FORMULA:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case BLANK:
			cellValue = "";
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;

		default:
			cellValue = "Invalid data type";
			break;
		}

		return cellValue;
	}

	public static void main(String[] args) throws IOException {
		ReadDataFromExcel readData = new ReadDataFromExcel();
		readData.setPath(System.getProperty("user.dir") + "/src/main/resources/testdata/aspireportal.xlsx");

	}
}
