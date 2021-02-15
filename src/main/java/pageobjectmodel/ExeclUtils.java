package pageobjectmodel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExeclUtils {

	@Test
	public void getExcelData()
	{
	try {
		FileInputStream fis= new FileInputStream("resources\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int countOfSheets=workbook.getNumberOfSheets();
		//IntStream.range(0,countOfSheets).filter(i->workbook.getSheetName(i).equals("Create_NewContacts")).forEach(i->System.out.println(workbook.getSheetAt(i)));
		for(int i=0; i<countOfSheets; i++)
		{
			if(workbook.getSheetName(i).equals("Create_NewContact"))
			{
				XSSFSheet desiredsheetName=workbook.getSheetAt(i);
				Iterator<Row> rows = desiredsheetName.iterator();
//				Row headerRow = rows.next();
//				Row firstRow = rows.next();
//				Iterator<Cell> cellIterator = firstRow.cellIterator();
				while(rows.hasNext())
				{
					Row row=rows.next();
					Iterator<Cell> cellIterator= row.iterator();
					while(cellIterator.hasNext())
					{
						Cell cell=cellIterator.next();
						
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
						System.out.print(cell.getStringCellValue() + "\t\t\t");  
						break;  
						case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
						System.out.print(cell.getNumericCellValue() + "\t\t\t");  
						break;  
						default:  
						}  
					}
					
				}
				
			}
			
		}
	} 
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
