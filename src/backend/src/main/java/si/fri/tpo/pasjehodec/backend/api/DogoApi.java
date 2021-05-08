package si.fri.tpo.pasjehodec.backend.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.services.DogoService;

@RestController
@RequestMapping("/dogos/")
@RequiredArgsConstructor
public class DogoApi {

    private final DogoService dogoService;

    @PostMapping("post")
    public ResponseEntity<DogoEntity> postDogo(@RequestBody DogoEntity dogo) {
        return ResponseEntity.ok(dogoService.addDogo(dogo, dogo.getOwner()));
    }
}
