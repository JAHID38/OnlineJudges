package oj.leetcode;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        int remainder = 0;
        StringBuilder excelColumn = new StringBuilder();
        while (columnNumber > 0){
            if (columnNumber < 27){
                excelColumn.append(Character.toString(columnNumber+64));
                break;
            }
            remainder = (columnNumber % 26 == 0) ? 26 : columnNumber % 26 ;
            excelColumn.append((char) (remainder+64));
            columnNumber /= 26;
            if (remainder == 26) columnNumber--;
        }
        return excelColumn.reverse().toString();
    }
}
