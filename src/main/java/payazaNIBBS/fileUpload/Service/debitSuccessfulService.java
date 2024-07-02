package payazaNIBBS.fileUpload.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import payazaNIBBS.fileUpload.Entity.debitSuccessful;
import payazaNIBBS.fileUpload.Repository.debitSuccessfulRepository;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class debitSuccessfulService {
    private debitSuccessfulRepository debitSuccessfulRepository;

    public void saveDebitSuccessfulToDatabase(MultipartFile file){
        if (excelUploadService.isValidExcelFile(file)){
            try
            {
                List<debitSuccessful>debits=excelUploadService.getDebitSuccessfulDataFromExcel(file.getInputStream());
                debitSuccessfulRepository.saveAll(debits);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not valid fam change it up");
            }
        }
    }
    public List<debitSuccessful>getDebits(){
        return debitSuccessfulRepository.findAll();
    }

}
