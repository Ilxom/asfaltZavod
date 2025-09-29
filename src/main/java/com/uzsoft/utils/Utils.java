package com.uzsoft.utils;

import com.sun.jna.Platform;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.List;

public class Utils {
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat fullDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static final SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat dateFormat4 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private static Connection connection;
    private static Statement statement;
    public static String applicationFolder;
    public static String reportFolder;
    public static String userName;
    public static String userFullName;

    public Utils() {
    }

    public static String formatDate2(Date date) {
        if (date == null) return "";
        return dateFormat2.format(date);
    }

    public static String formatDate3(Date date) {
        if (date == null) return "";
        return dateFormat3.format(date) + " " + timeFormat.format(date);
    }

    public static String formatDate4(Date date) {
        if (date == null) return "";
        return dateFormat4.format(date);
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cas?verifyServerCertificate=false&useSSL=false&requireSSL=false&useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true", "root", "u1DR4GGEAZme");
        } catch (ClassNotFoundException | SQLException var1) {
            var1.printStackTrace();
        }

        return connection;
    }

    public static Statement getStatement() {
        try {
            connection = getConnection();
            statement = connection.createStatement();
        } catch (SQLException var1) {
            var1.printStackTrace();
        }

        return statement;
    }

    public static void closeConnection() {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException var1) {
            var1.printStackTrace();
        }

    }

    public static Date getDayStart(Date date) {
        GregorianCalendar sdCal = new GregorianCalendar();
        sdCal.setTime(date);
        getDayStart(sdCal);
        return sdCal.getTime();
    }

    public static void getDayStart(GregorianCalendar sdCal) {
        sdCal.set(Calendar.HOUR_OF_DAY, 0);
        sdCal.set(Calendar.MINUTE, 0);
        sdCal.set(Calendar.SECOND, 0);
        sdCal.set(Calendar.MILLISECOND, 0);
        sdCal.getTime();
    }

    public static Date getDayEnd(Date date) {
        GregorianCalendar sdCal = new GregorianCalendar();
        sdCal.setTime(date);
        getDayEnd(sdCal);
        return sdCal.getTime();
    }

    public static void getDayEnd(GregorianCalendar sdCal) {
        sdCal.set(Calendar.HOUR_OF_DAY, 23);
        sdCal.set(Calendar.MINUTE, 59);
        sdCal.set(Calendar.SECOND, 59);
        sdCal.set(Calendar.MILLISECOND, 999);
    }

    public static String getMonthFirstDay() {
        GregorianCalendar sdCal = new GregorianCalendar();
        sdCal.setTime(new Date());
        sdCal.set(Calendar.DATE, 1);
        sdCal.set(Calendar.HOUR_OF_DAY, 0);
        sdCal.set(Calendar.MINUTE, 0);
        sdCal.set(Calendar.SECOND, 0);
        sdCal.set(Calendar.MILLISECOND, 0);
        Date time = sdCal.getTime();
        return dateFormat2.format(time);
    }

    public static String getMonthLastDay() {
        GregorianCalendar sdCal = new GregorianCalendar();
        sdCal.setTime(new Date());
        sdCal.set(Calendar.MONTH, sdCal.get(2) + 1);
        sdCal.set(Calendar.DATE, 1);
        sdCal.set(Calendar.HOUR_OF_DAY, 0);
        sdCal.set(Calendar.MINUTE, 0);
        sdCal.set(Calendar.SECOND, 0);
        sdCal.set(Calendar.MILLISECOND, 0);
        sdCal.set(Calendar.SECOND, sdCal.get(Calendar.SECOND) - 1);
        Date time = sdCal.getTime();
        return dateFormat2.format(time);
    }

    public static void exportToWord(Integer weightId) {
        try {
            Statement statement = Utils.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weight where id=" + weightId);
            resultSet.next();
            XWPFDocument document = new XWPFDocument();
            document.setMirrorMargins(true);

            //Create header table
            XWPFTable headerTable = document.createTable(3, 2);
            headerTable.getCTTbl().getTblPr().unsetTblBorders();
            headerTable.setTableAlignment(TableRowAlign.RIGHT);

            XWPFTableRow headerTableRow = headerTable.getRow(0);
            createHeaderCell(headerTableRow, "Акт взвешивание №", 0);
            createHeaderCell(headerTableRow, weightId.toString(), 1);
            headerTable.getRow(0).getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);

            headerTableRow = headerTable.getRow(1);
            createHeaderCell(headerTableRow, "Время взвешивание 1: ", 0);
            createHeaderCell(headerTableRow, Utils.formatDate3(resultSet.getTimestamp("tareDate")), 1);

            headerTableRow = headerTable.getRow(2);
            createHeaderCell(headerTableRow, "Время взвешивание 2: ", 0);
            createHeaderCell(headerTableRow, Utils.formatDate3(resultSet.getTimestamp("grossDate")), 1);

            document.createParagraph().createRun().setText("   ");

            //Create common data table
            XWPFTable tableOne = document.createTable(7, 0);
            CTTblWidth tblWidth = tableOne.getCTTbl().getTblPr().addNewTblW();
            tblWidth.setType(STTblWidth.DXA);
            tblWidth.setW(BigInteger.valueOf(10000L));
            int i = 0;

            XWPFTableRow tableRowOne = tableOne.getRow(i++);
            tableRowOne.setHeight(20);
            createHeaderCell(tableRowOne, "Номер автомобиля", 0);
            createHeaderCell(tableRowOne, resultSet.getString("carNumber"), 1);

            tableRowOne = tableOne.getRow(i++);
            createHeaderCell(tableRowOne, "Модель", 0);
            createHeaderCell(tableRowOne, resultSet.getString("carModel"), 1);

            tableRowOne = tableOne.getRow(i++);
            createHeaderCell(tableRowOne, "Товар", 0);
            createHeaderCell(tableRowOne, resultSet.getString("productName"), 1);

            tableRowOne = tableOne.getRow(i++);
            createHeaderCell(tableRowOne, "Отправитель", 0);
            createHeaderCell(tableRowOne, resultSet.getString("sender"), 1);

            tableRowOne = tableOne.getRow(i++);
            createHeaderCell(tableRowOne, "Получатель", 0);
            createHeaderCell(tableRowOne, resultSet.getString("receiver"), 1);

            tableRowOne = tableOne.getRow(i++);
            createHeaderCell(tableRowOne, "Водитель", 0);
            createHeaderCell(tableRowOne, resultSet.getString("carDriver"), 1);

            tableRowOne = tableOne.getRow(i++);
            createHeaderCell(tableRowOne, "Весовщик", 0);
            createHeaderCell(tableRowOne, resultSet.getString("operator"), 1);

            document.createParagraph().createRun().setText("   ");

            //Create weight table
            XWPFTable weightTable = document.createTable(2, 3);
            CTTblWidth weightTableWidth = weightTable.getCTTbl().getTblPr().addNewTblW();
            weightTableWidth.setType(STTblWidth.DXA);
            weightTableWidth.setW(BigInteger.valueOf(10000L));

            XWPFTableRow tableTwo = weightTable.getRow(0);
            createHeaderCell(tableTwo, "ТАРА", 0);
            createHeaderCell(tableTwo, "БРУТТО", 1);
            createHeaderCell(tableTwo, "НЕТТО", 2);
            tableTwo.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableTwo.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableTwo.getCell(2).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);

            tableTwo = weightTable.getRow(1);
            createHeaderCell(tableTwo, resultSet.getString("tare"), 0);
            createHeaderCell(tableTwo, resultSet.getString("gross"), 1);
            createHeaderCell(tableTwo, resultSet.getString("net"), 2);
            tableTwo.getCell(0).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableTwo.getCell(1).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
            tableTwo.getCell(2).getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);

            document.createParagraph().createRun().setText("   ");

            //Create signs table
            XWPFTable tableThree = document.createTable(2, 3);
            tableThree.getCTTbl().getTblPr().unsetTblBorders();
            CTTblWidth tableThreeWidth = tableThree.getCTTbl().getTblPr().addNewTblW();
            tableThreeWidth.setType(STTblWidth.DXA);
            tableThreeWidth.setW(BigInteger.valueOf(10000L));

            XWPFTableRow tableThreeRow = tableThree.getRow(0);
            createHeaderCell(tableThreeRow, "Весовщик", 0);
            createHeaderCell(tableThreeRow, "_______________________________", 1);
            tableThree.getRow(0).getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);
            createHeaderCell(tableThreeRow, "_______________________________", 2);
            tableThree.getRow(0).getCell(2).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);

            tableThreeRow = tableThree.getRow(1);
            createHeaderCell(tableThreeRow, "Клиент", 0);
            createHeaderCell(tableThreeRow, "_______________________________", 1);
            tableThree.getRow(0).getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);
            createHeaderCell(tableThreeRow, "_______________________________", 2);
            tableThree.getRow(0).getCell(2).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);

            FileOutputStream out = new FileOutputStream(reportFolder + weightId + ".docx");
            document.write(out);
            out.close();
            Desktop.getDesktop().open(new File(reportFolder + weightId + ".docx"));
        } catch (SQLException | IOException var10) {
            var10.printStackTrace();
        }
    }

    private static void createHeaderCell(XWPFTableRow tableRowOne, String text, int cellNumber) {
        tableRowOne.setHeight(20);
        XWPFTableCell cell = tableRowOne.getCell(cellNumber);
        if (cell == null) {
            cell = tableRowOne.createCell();
        }
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);
        XWPFParagraph paragraph = cell.getParagraphArray(0);
        if (paragraph == null) {
            paragraph = cell.addParagraph();
            paragraph.setSpacingAfter(0);
        }

        createRun(paragraph, text, 12, true);
    }

    private static void createRun(XWPFParagraph paragraph, String text, int fontSize, boolean isBold) {
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setFontSize(fontSize);
        run.setBold(isBold);
    }

    public static <T> java.util.List<T> convertSQLResultSetToObject(ResultSet resultSet, Class<T> clazz) {
        List<T> list = null;
        try {
            Field[] fields = clazz.getDeclaredFields();
            for(Field field: fields) {
                field.setAccessible(true);
            }

            list = new ArrayList<T>();
            while(resultSet.next()) {
                T dto = clazz.getConstructor().newInstance();
                for(Field field: fields) {
                    String name = field.getName();
                    try{
                        if (field.getType().isAssignableFrom(String.class)) {
                            field.set(dto, resultSet.getString(name));
                        } else if (field.getType().isAssignableFrom(Integer.class)) {
                            field.set(dto, resultSet.getInt(name));
                        } else if (field.getType().isAssignableFrom(java.sql.Date.class)) {
                            field.set(dto, resultSet.getTimestamp(name));
                        }
                    } catch (Exception ignored) {
                    }
                }
                list.add(dto);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static String getOsPrefix() {
        String arch = System.getProperty("os.arch").toLowerCase();
        final String name = System.getProperty("os.name");
        String osPrefix;
        switch(Platform.getOSType()) {
            case Platform.WINDOWS: {
                if ("i386".equals(arch))
                    arch = "x86";
                osPrefix = "win32-" + arch;
            }
            break;
            case Platform.LINUX: {
                if ("x86".equals(arch)) {
                    arch = "i386";
                }
                else if ("x86_64".equals(arch)) {
                    arch = "amd64";
                }
                osPrefix = "linux-" + arch;
            }
            break;
            default: {
                osPrefix = name.toLowerCase();
                if ("x86".equals(arch)) {
                    arch = "i386";
                }
                if ("x86_64".equals(arch)) {
                    arch = "amd64";
                }
                int space = osPrefix.indexOf(" ");
                if (space != -1) {
                    osPrefix = osPrefix.substring(0, space);
                }
                osPrefix += "-" + arch;
            }
            break;

        }

        return osPrefix;
    }

    public static String getLoadLibrary(String library) {
        String loadLibrary = applicationFolder + "/lib/win64/";

        System.out.printf("[Load %s Path : %s]\n", library, loadLibrary + library);
        return loadLibrary + library;
    }
}