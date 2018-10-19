import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        //WriteInExcelFile("C:\\FlexCubeParallelTesting\\src\\DWH\\Employee.xlsx","Employees");
        for (Employee emp : Employees()) {
            System.out.println(emp.name + " "+emp.surname);
        }
        System.out.println("Success");
    }


    public static void WriteInExcelFile(String excelFileName, String sheetName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(sheetName);

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map<String, Object[]> empinfo =
                new TreeMap<>();
        empinfo.put("1", new Object[]{"EMP ID", "EMP NAME", "DESIGNATION"});
        empinfo.put("2", new Object[]{"tp01", "Gopal", "Technical Manager"});
        empinfo.put("3", new Object[]{"tp02", "Manisha", "Proof Reader"});
        empinfo.put("4", new Object[]{"tp03", "Masthan", "Technical Writer"});
        empinfo.put("5", new Object[]{"tp04", "Satish", "Technical Writer"});
        empinfo.put("6", new Object[]{"tp05", "Krishna", "Technical Writer"});

        //Iterate over data and write to sheet
        Set<String> keyid = empinfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File(excelFileName));
        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully");
    }

    public boolean CheckIFPossibleReadExcelFile() throws IOException {
        File myExcelFile = new File("C:\\FlexCubeParallelTesting\\src\\DWH\\Emps.xlsx");
        FileInputStream fip = new FileInputStream(myExcelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fip);

        if (myExcelFile.isFile() && myExcelFile.exists())
            return true;
        else return false;
    }

    public static List<Employee> Employees() throws IOException {
        XSSFRow row;
        Cell cell;
        List<Employee> employeeList = new ArrayList<>();
        ArrayList<Cell> cells = new ArrayList<>();
        Hashtable<String,Cell> cellHashtable = new Hashtable<>();
        Employee employee;
        FileInputStream fis = new FileInputStream(new File("C:\\FlexCubeParallelTesting\\src\\DWH\\Employee.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Employees");
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            employee = new Employee();
            row = (XSSFRow) rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            cells = PrepareObjectList(cellIterator);
            if(row.getRowNum()== 0){
                cellHashtable = GetExcelSheetHeaders(cells);
            }
            //row.getRowNum() == 0 || (cell.getAddress().getColumn() == row.getLastCellNum()-1 && cell.getStringCellValue().toUpperCase().equals("Y"))
            else {
                if (!cells.get(cells.size() - 1).getStringCellValue().equals("Y")) {
                    employee = new Employee();
                    //for (int i = 0; i < row.getLastCellNum(); i++) {
                        employee.Id = cells.get(0).getNumericCellValue();
                        employee.name = cells.get(1).getStringCellValue();
                        employee.surname = cells.get(2).getStringCellValue();
                        employeeList.add(employee);
                    //}
                }
            }

        }

        return employeeList;
    }


    public static <T> ArrayList<T> PrepareObjectList(Iterator<T> objectIterator) {
        ArrayList<T> list = new ArrayList<>();
        while (objectIterator.hasNext()) {
            T t = objectIterator.next();
            list.add(t);
        }

        return list;
    }

    public static <K, V> Hashtable<K, V> GetExcelSheetHeaders(ArrayList<Cell> cellArrayList){
        Hashtable<K, V> excelSheetHeaders = new Hashtable<>();
        for (Cell cell : cellArrayList) {
            K k = (K)cell.getStringCellValue();
            V v = (V)cell;
            excelSheetHeaders.put(k,v);
        }

        return excelSheetHeaders;

    }


}
