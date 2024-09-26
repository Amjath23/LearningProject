package Utilities;



	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileInputStream;
	import java.io.IOException;

	public class ExcelUtil {

	    private XSSFWorkbook workbook;

	    public ExcelUtil(String filePath) throws IOException {
	        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\Book2");
	        workbook = new XSSFWorkbook(fis);
	    }

	    public String getCellData(String sheetName, int rowNum, int colNum) {
	        Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(rowNum);
	        DataFormatter formatter = new DataFormatter();
	        return formatter.formatCellValue(row.getCell(colNum));
	    }

	    public int getRowCount(String sheetName) {
	        return workbook.getSheet(sheetName).getLastRowNum();
	    }

	    public int getColumnCount(String sheetName) {
	        return workbook.getSheet(sheetName).getRow(0).getLastCellNum();
	    }

	    public void close() throws IOException {
	        workbook.close();
	    }
	}


