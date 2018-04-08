package edu.gatech.mdiamond8.partytrack.excel;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
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

public class ExcelWriter {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;
    private ResultSet resultSet;

    public void setOutputFile(String inputFile, ResultSet resultSet) {
        this.inputFile = inputFile;
        this.resultSet = resultSet;
    }

    public void write() throws Exception {
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
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
        // Define the cell format
        times = new WritableCellFormat(times12pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
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
        addCaption(sheet, 0, 0, "Name");
        addCaption(sheet, 1, 0, "Drink");
        addCaption(sheet, 2, 0, "Prior Drinks");
        addCaption(sheet, 3, 0, "Alcohol Consumed");

    }

    private void createContent(WritableSheet sheet) throws Exception {
        // now a bit of text
        for (int i = 1; resultSet.next(); i++) {
            addLabel(sheet, 0, i, resultSet.getString("NAME"));
            addLabel(sheet, 1, i, resultSet.getString("DRINK"));
            addLabel(sheet, 2, i, resultSet.getString("DRINKSHAD"));
            addLabel(sheet, 3, i, resultSet.getString("ALCOHOLCONSUMED"));
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

}
