package testng2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		//Step1-> Set path for workbook
//		step2-> Get into the sheet
//		Step3-> Get into Row values
//		Step4-> Get into cell values
//		Step5-> Read Data from workbook and print
//		Step6-> close the workbook
		
		//step 1- setup the path of the workbook
		XSSFWorkbook wb=new XSSFWorkbook("./dataXLsheet/Leads.xlsx");
		
		//step 2
		//wb.getSheet("Leads"); //sheet name
		XSSFSheet sheet = wb.getSheetAt(0); //sheet index number
		
		//step3 -read number of row present
		//excluding header
		int rowCount = sheet.getLastRowNum();
		System.out.println("Number of rows present in sheet :"+rowCount);
		
		//including header
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("including the header value : "+physicalNumberOfRows);

		//step4 From the Row need to call the cell and in assign default will be short change to int
		int cellCount = sheet.getRow(1).getLastCellNum();
		System.out.println("Number of cells present in sheet : "+cellCount);
		
		//step 5 
		String ss = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(ss);
		
		//nested for loop
		//index '0' header value ,for row it should start from '1'
		for (int i = 1; i <=rowCount; i++) {
			
			for (int j = 0; j < cellCount; j++) {
				
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				
				System.out.println(data);
			}
		}
		
		//step 6 close the workbook
		wb.close();
	}




	}


