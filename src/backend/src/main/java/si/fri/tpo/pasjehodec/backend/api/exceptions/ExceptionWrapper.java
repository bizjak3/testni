package si.fri.tpo.pasjehodec.backend.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionWrapper {
    private List<String> errors;

    public ExceptionWrapper(String error) {
        this.errors = List.of(error);
    }
}
