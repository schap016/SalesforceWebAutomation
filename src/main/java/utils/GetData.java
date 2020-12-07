package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetData {


	
	public static List<String> getClassNamesTestNames(String sheetName, String colName, String filePath) {
		List<String> classNamesTestNames = new ArrayList<String>();

		try {
			XSSFWorkbook workbook = null;
			XSSFRow firstRow = null;
			XSSFRow row = null;
			int classNameIndex = 0;
			int testNameIndex = 0;
			int executeColIndex = 0;
			int testDataColIndex = 0;
			int userNameColIndex = 0;

			workbook = new XSSFWorkbook(filePath);
			// System.out.println(workbook.getNumberOfSheets());

			XSSFSheet sheet = workbook.getSheet("TestNames");

			int numberOfRows = sheet.getLastRowNum();

			// get first row of sheet "TestNames" - to read column names/header
			firstRow = sheet.getRow(0);

			for (int i = 0; i < firstRow.getLastCellNum(); i++) {

				if (firstRow.getCell(i).getStringCellValue().equals(colName)) {
					classNameIndex = i;
					testNameIndex = i - 1;
					executeColIndex = i + 1;
					testDataColIndex = i+2;
					userNameColIndex = i+3;
					
				}

			}

			for (int i = 1; i < numberOfRows + 1; i++) {

				row = sheet.getRow(i);

				XSSFCell classcellValue = row.getCell(classNameIndex);
				XSSFCell testCellValue = row.getCell(testNameIndex);
				XSSFCell executeCellValue = row.getCell(executeColIndex);
				XSSFCell dataCellValue = row.getCell(testDataColIndex);
				XSSFCell userCellValue = row.getCell(userNameColIndex);
				if (executeCellValue.toString().equalsIgnoreCase("Y")) {

					classNamesTestNames.add(classcellValue.toString());
					classNamesTestNames.add(testCellValue.toString());
					classNamesTestNames.add(dataCellValue.toString());
					classNamesTestNames.add(userCellValue.toString());
				}

			}

			workbook.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);

		} catch (IOException e) {

			System.out.println(e);

		} catch (Exception e) {

			System.out.println(e);

		}
		return classNamesTestNames;

	}

	
}
