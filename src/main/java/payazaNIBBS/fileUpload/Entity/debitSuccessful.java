package payazaNIBBS.fileUpload.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class debitSuccessful {
    @Id
    private String transactionId;
    private String sessionId;
    private String status;
    private String message;
    private String nipResponseCode;
    private String nameEnquiryRef;
    private String destinationInstitutionCode;
    private String channelCode;
    private String beneficiaryAccountName;
    private String beneficiaryAccountNumber;
    private String beneficiaryBvn;
    private String beneficiaryKycLevel;
    private String debitAccountName;
    private String debitAccountNumber;
    private String debitBvn;
    private String debitKycLevel;
    private String narration;
    private String paymentReference;
    private String amount;
    private String transactionLocation;
}
