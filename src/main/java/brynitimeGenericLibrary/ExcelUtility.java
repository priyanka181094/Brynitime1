package brynitimeGenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {

	
		public String fetchDatafromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(IpathConstants.excelsheetpath);
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheet(sheet);
			DataFormatter format=new DataFormatter();
			String value=format.formatCellValue(sh.getRow(row).getCell(cell));
			return value;
			// TODO Auto-generated method stub

		}
		
		public int getRowNum(String sheet) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(IpathConstants.excelsheetpath);	
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheet);
			int rownum=sh.getLastRowNum();
			return rownum;
		}
		//
		public void insertDataintoExcel(String sheet,int row,int cell,String value)throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstants.excelsheetpath);	
			Workbook wb2=WorkbookFactory.create(fis);
			Sheet sh=wb2.getSheet(sheet);
			FileOutputStream fos=new FileOutputStream(IpathConstants.excelsheetpath);	
			sh.createRow(row).createCell(cell).setCellValue(value);
			wb2.write(fos);
			fos.flush();
		
		}
		//exceldata for admin module
		public String fetchDatafromExceladmin(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis2=new FileInputStream(IpathConstants.excelsheetpathadmin);
			Workbook book=WorkbookFactory.create(fis2);
			Sheet sh=book.getSheet(sheet);
			DataFormatter format=new DataFormatter();
			String value=format.formatCellValue(sh.getRow(row).getCell(cell));
			return value;
			// TODO Auto-generated method stub

		}
		
		
		
		//using hashmap for singup page
		public HashMap<String,String> fetchdatamap(String sheetname)throws Throwable
		{
			FileInputStream fis=new FileInputStream(IpathConstants.excelsheetpath);
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheet(sheetname);
			int  rowcount=sh.getLastRowNum();
			DataFormatter format=new DataFormatter();
			
			
			HashMap<String,String>map=new HashMap<String,String>();
			for(int i=0;i<=rowcount;i++)
			{
				String key=format.formatCellValue(sh.getRow(i).getCell(0));
				String value=format.formatCellValue(sh.getRow(i).getCell(1));
				
				System.out.println(key+"..."+value);
				map.put(key, value);
				
			}
			return map;
		}

	

		// TODO Auto-generated method stub
 
	}


