package si.fri.tpo.pasjehodec.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestApi {

    @GetMapping
    public String dela() {
        return "dela";
    }
}
