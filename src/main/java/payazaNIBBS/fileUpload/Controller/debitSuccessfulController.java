package payazaNIBBS.fileUpload.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import payazaNIBBS.fileUpload.Entity.debitSuccessful;
import payazaNIBBS.fileUpload.Service.debitSuccessfulService;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class debitSuccessfulController {
    private debitSuccessfulService debitSuccessfulService;
    @PostMapping("/debitSuccessful")
    public ResponseEntity<?> uploaddebitSuccessfulfile(@RequestParam("file") MultipartFile file){
        this.debitSuccessfulService.saveDebitSuccessfulToDatabase(file);
        return ResponseEntity.ok(Map.of("Message","data uploaded and saved to database successfuly"));
    }
    @GetMapping
    public ResponseEntity<List<debitSuccessful>>getdebits(){
        return new ResponseEntity<>(debitSuccessfulService.getDebits(), HttpStatus.FOUND);
    }
}
