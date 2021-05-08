package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServices {

    public boolean isEmailValid(String email) {
        EmailValidator emailValidator = EmailValidator.getInstance(false, false);
        return emailValidator.isValid(email);
    }
}
