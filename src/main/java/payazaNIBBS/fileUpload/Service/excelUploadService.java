package payazaNIBBS.fileUpload.Service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import payazaNIBBS.fileUpload.Entity.debitSuccessful;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class excelUploadService {
    public static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<debitSuccessful> getDebitSuccessfulDataFromExcel(InputStream inputStream) {
        List<debitSuccessful> debitSuccessfulList = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("debit_successful");

            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                debitSuccessful debit = new debitSuccessful();
                int cellIndex = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = cell.getStringCellValue(); // Treat all cells as string

                    switch (cellIndex) {
                        case 0 -> debit.setTransactionId(cellValue);
                        case 1 -> debit.setSessionId(cellValue);
                        case 2 -> debit.setStatus(cellValue);
                        case 3 -> debit.setMessage(cellValue);
                        case 4 -> debit.setNipResponseCode(cellValue);
                        case 5 -> debit.setNameEnquiryRef(cellValue);
                        case 6 -> debit.setDestinationInstitutionCode(cellValue);
                        case 7 -> debit.setChannelCode(cellValue);
                        case 8 -> debit.setBeneficiaryAccountName(cellValue);
                        case 9 -> debit.setBeneficiaryAccountNumber(cellValue);
                        case 10 -> debit.setBeneficiaryBvn(cellValue);
                        case 11 -> debit.setBeneficiaryKycLevel(cellValue);
                        case 12 -> debit.setDebitAccountName(cellValue);
                        case 13 -> debit.setDebitAccountNumber(cellValue);
                        case 14 -> debit.setDebitBvn(cellValue);
                        case 15 -> debit.setDebitKycLevel(cellValue);
                        case 16 -> debit.setNarration(cellValue);
                        case 17 -> debit.setPaymentReference(cellValue);
                        case 18 -> debit.setAmount(cellValue);
                        case 19 -> debit.setTransactionLocation(cellValue);
                        default -> {

                        }
                    }

                    cellIndex++;
                }

                debitSuccessfulList.add(debit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return debitSuccessfulList;
    }
}
