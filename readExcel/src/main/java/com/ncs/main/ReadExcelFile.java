package com.ncs.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ncs.model.Candidate;
import com.ncs.util.ExcelConstants;
import com.ncs.util.ExcelUtilHelper;

public class ReadExcelFile {

	public static void main(String args[]) {

		List<Candidate> candidateList = new ArrayList<Candidate>();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(ExcelConstants.FILE_PATH);
			Workbook workbook = new XSSFWorkbook(fileInputStream);

			int numberOfSheets = workbook.getNumberOfSheets();

			// looping over each workbook sheet
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet sheet = workbook.getSheetAt(i);
				Iterator rowIterator = sheet.iterator();
				rowIterator.next();
				// iterating over each row
				while (rowIterator.hasNext()) {
					Candidate candidate = new Candidate();
					Row row = (Row) rowIterator.next();
					Iterator cellIterator = row.cellIterator();
					// Iterating over each cell (column wise) in a particular row.
					readCell(candidate, cellIterator);
					candidateList.add(candidate);

				}
			}
			ExcelUtilHelper.prepareJson(candidateList);
		/*	final String response = ExcelUtilHelper.prepareResult(ExcelConstants.SUCCESS_MSG,
					ExcelConstants.SUCCESS_STATUS_CODE, jsonResult);
			System.out.println(response.toString());*/

		} catch (FileNotFoundException e) {
			final String response = "";//;ExcelUtilHelper.prepareResult(ExcelConstants.FAILURE_MSG,
				/*	ExcelConstants.FAILURE_STATUS_CODE,  new JsonParser().parse(new JSONObject().put("Reason","File Not Found.." ).toString()).getAsJsonObject());
			System.out.println(response.toString());*/
			
		} catch (IOException e) {
			System.out.println("IOException occured...");
		}

	}

	private static void readCell(final Candidate candidate, final Iterator cellIterator) {
		while (cellIterator.hasNext()) {
			Cell cell = (Cell) cellIterator.next();
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				populateNumericCells(candidate, cell);
			case Cell.CELL_TYPE_STRING:
				populateStringCells(candidate, cell);
			default:
				break;
			}
		}
	}

	private static void populateStringCells(Candidate candidate, Cell cell) {
		switch (cell.getColumnIndex()) {
		case 0:
			candidate.setFirstName(cell.getStringCellValue());
			break;
		case 1:
			candidate.setLastName(cell.getStringCellValue());
			break;
		case 2:
			candidate.setCountry(cell.getStringCellValue());
			break;
		case 3:
			candidate.setContactEmail(cell.getStringCellValue());
			break;
		}
	}

	private static void populateNumericCells(Candidate candidate, Cell cell) {
		switch (cell.getColumnIndex()) {
		case 4:
			candidate.setCellPhone((int) cell.getNumericCellValue());
			break;
		}
	}

}
