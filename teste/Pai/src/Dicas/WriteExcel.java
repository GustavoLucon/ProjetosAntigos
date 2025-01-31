package Dicas;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class WriteExcel {

	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private String inputFile;
	
public void setOutputFile(String inputFile) {
	this.inputFile = inputFile;
	}

	public void write() throws IOException, WriteException {
		File file = new File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		createLabel(excelSheet);
		createContent(excelSheet);

		workbook.write();
		workbook.close();
	}

	private void createLabel(WritableSheet sheet)
			throws WriteException {
		// Lets create a times font
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		// Define the cell format
		times = new WritableCellFormat(times10pt);
		// Lets automatically wrap the cells
		times.setWrap(true);

		// Create create a bold font with unterlines
		WritableFont times10ptBoldUnderline = new WritableFont(
				WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		// Lets automatically wrap the cells
		timesBoldUnderline.setWrap(true);

		CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);

		// Write a few headers
		addCaption(sheet, 0, 0, "IPS");
		addCaption(sheet, 1, 0, "Gateway");
		addCaption(sheet, 2, 0, "Disponivel");
		addCaption(sheet, 3, 0, "Descri��o");
		addCaption(sheet, 4, 0, "Equipamento");
		addCaption(sheet, 5, 0, "Mascara");
		addCaption(sheet, 6, 0, "Site");
		addCaption(sheet, 7, 0, "DNS");
		
	}

	private void createContent(WritableSheet sheet) throws WriteException,
			RowsExceededException {
		// Write a few number
		int altura =1;
		for (int i = 0; i <= 255; i++) {
			for (int a = 1; a < 255; a++) {
			addLabel(sheet, 0, altura, "10.21." + i + "." + a);
			addLabel(sheet, 2, altura, "Disponivel");
			altura++;
		}

		}
	}

	private void addCaption(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, timesBoldUnderline);
		sheet.addCell(label);
	}

	private void addNumber(WritableSheet sheet, int column, int row,
			Integer integer) throws WriteException, RowsExceededException {
		Number number;
		number = new Number(column, row, integer, times);
		sheet.addCell(number);
	}

	private void addLabel(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, times);
		sheet.addCell(label);
	}

	public static void main(String[] args) throws WriteException, IOException {
		WriteExcel test = new WriteExcel();
		test.setOutputFile("c:/lars.xls");
		test.write();
		System.out
				.println("Please check the result file under c:/temp/lars.xls ");
	}
}
