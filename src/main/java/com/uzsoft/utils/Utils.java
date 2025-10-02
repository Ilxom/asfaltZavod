package com.uzsoft.utils;

import com.sun.jna.Platform;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import javax.swing.*;
import java.awt.*;
import java.io.*;
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

            FileInputStream inputStream = new  FileInputStream(applicationFolder + "/files/wordTemplate.docx");
            XWPFDocument document = new XWPFDocument(inputStream);
            document.setMirrorMargins(true);

            for (XWPFTable p : document.getTables()) {
                List<XWPFTableRow> rows = p.getRows();
                rows.forEach(row -> {
                    row.getTableCells().forEach(tableCell -> {
                        tableCell.getParagraphs().forEach(paragraph -> {
                            paragraph.getRuns().forEach(r -> {
                                String text = r.getText(0);
                                try {
                                    if (text != null && text.contains("documentNumber")) {
                                        text = text.replace("documentNumber", weightId.toString());
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{weighingDate1}")) {
                                        text = text.replace("{weighingDate1}", Utils.formatDate3(resultSet.getTimestamp("tareDate")));
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{weighingDate2}")) {
                                        text = text.replace("{weighingDate2}", Utils.formatDate3(resultSet.getTimestamp("grossDate")));
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("carNumber")) {
                                        text = text.replace("carNumber", resultSet.getString("carNumber") != null ? resultSet.getString("carNumber") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("carModel")) {
                                        text = text.replace("carModel", resultSet.getString("carModel") != null ? resultSet.getString("carModel") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{product}")) {
                                        text = text.replace("{product}", resultSet.getString("productName") != null ? resultSet.getString("productName") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{sender}")) {
                                        text = text.replace("{sender}", resultSet.getString("sender") != null ? resultSet.getString("sender") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{receiver}")) {
                                        text = text.replace("{receiver}", resultSet.getString("receiver") != null ? resultSet.getString("receiver") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{driver}")) {
                                        text = text.replace("{driver}", resultSet.getString("carDriver") != null ? resultSet.getString("carDriver") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{operator}")) {
                                        text = text.replace("{operator}", resultSet.getString("operator") != null ? resultSet.getString("operator") : "");
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{tare}")) {
                                        text = text.replace("{tare}", resultSet.getString("tare"));
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{gross}")) {
                                        text = text.replace("{gross}", resultSet.getString("gross"));
                                        r.setText(text, 0);
                                    } else if (text != null && text.contains("{net}")) {
                                        text = text.replace("{net}", resultSet.getString("net"));
                                        r.setText(text, 0);
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                        });
                    });
                });
            }

            FileOutputStream outputStream = new FileOutputStream(reportFolder + weightId + ".docx");
            document.write(outputStream);
            outputStream.close();
            inputStream.close();
            document.close();
            Desktop.getDesktop().open(new File(reportFolder + weightId + ".docx"));
        } catch (SQLException | IOException var10) {
            var10.printStackTrace();
        }
    }

    private static void createHeaderCell(XWPFTableRow tableRowOne, String text, int cellNumber) {
        tableRowOne.setHeight(17);
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

        createRun(paragraph, text, 11, true);
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
            for (Field field : fields) {
                field.setAccessible(true);
            }

            list = new ArrayList<T>();
            while (resultSet.next()) {
                T dto = clazz.getConstructor().newInstance();
                for (Field field : fields) {
                    String name = field.getName();
                    try {
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
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static String getOsPrefix() {
        String arch = System.getProperty("os.arch").toLowerCase();
        final String name = System.getProperty("os.name");
        String osPrefix;
        switch (Platform.getOSType()) {
            case Platform.WINDOWS: {
                if ("i386".equals(arch))
                    arch = "x86";
                osPrefix = "win32-" + arch;
            }
            break;
            case Platform.LINUX: {
                if ("x86".equals(arch)) {
                    arch = "i386";
                } else if ("x86_64".equals(arch)) {
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

    public static void exportToExcel(Integer weightId) {
        try {
            Statement statement = Utils.getStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weight where id=" + weightId);
            resultSet.next();

            FileInputStream inputStream = new FileInputStream(applicationFolder + "/files/excelTemplate.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int j = 1; j < 50; j++) {
                Row row = sheet.getRow(j);
                if (row != null) {
                    for (int i = 1; i <= 3; i++) {
                        Cell cell = row.getCell(i);
                        if (cell != null) {
                            if (cell.getStringCellValue().contains("{documentNumber}")) {
                                cell.setCellValue(weightId.toString());
                            } else if (cell.getStringCellValue().contains("{weighingDate1}")) {
                                cell.setCellValue(Utils.formatDate3(resultSet.getTimestamp("tareDate")));
                            } else if (cell.getStringCellValue().contains("{weighingDate2}")) {
                                cell.setCellValue(Utils.formatDate3(resultSet.getTimestamp("grossDate")));
                            } else if (cell.getStringCellValue().contains("{carNumber}")) {
                                cell.setCellValue(resultSet.getString("carNumber"));
                            } else if (cell.getStringCellValue().contains("{carModel}")) {
                                cell.setCellValue(resultSet.getString("carModel"));
                            } else if (cell.getStringCellValue().contains("{product}")) {
                                cell.setCellValue(resultSet.getString("productName"));
                            } else if (cell.getStringCellValue().contains("{sender}")) {
                                cell.setCellValue(resultSet.getString("sender"));
                            } else if (cell.getStringCellValue().contains("{receiver}")) {
                                cell.setCellValue(resultSet.getString("receiver"));
                            } else if (cell.getStringCellValue().contains("{driver}")) {
                                cell.setCellValue(resultSet.getString("carDriver"));
                            } else if (cell.getStringCellValue().contains("{operator}")) {
                                cell.setCellValue(resultSet.getString("operator"));
                            } else if (cell.getStringCellValue().contains("{tare}")) {
                                cell.setCellValue(resultSet.getString("tare"));
                            } else if (cell.getStringCellValue().contains("{gross}")) {
                                cell.setCellValue(resultSet.getString("gross"));
                            } else if (cell.getStringCellValue().contains("{net}")) {
                                cell.setCellValue(resultSet.getString("net"));
                            }
                        }
                    }
                }
            }

            FileOutputStream outputStream = new FileOutputStream(reportFolder + weightId + ".xlsx");
            workbook.write(outputStream);
            outputStream.close();
            inputStream.close();
            workbook.close();
            Desktop.getDesktop().open(new File(reportFolder + weightId + ".xlsx"));

        } catch (SQLException var5) {
            var5.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}