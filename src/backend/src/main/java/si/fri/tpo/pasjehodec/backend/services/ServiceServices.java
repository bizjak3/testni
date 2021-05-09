package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ServiceServices {
    private final ServiceRepository serviceRepository;

    public ServiceEntity addService(ServiceEntity service) throws BadRequestException, ForbiddenOperationException {
        if(service.getDateFrom().isAfter(service.getDateTo()))
            throw new BadRequestException("Začetni datum ne more biti večji od zaključnega");
        if(service.getDateTo().isBefore(LocalDateTime.now()))
            throw new BadRequestException("Končni datum ne more biti starejši od trenutnega");

        if(service.getId() != null) {
            var o = serviceRepository.findById(service.getId());
            if(o.isPresent()) {
                var serviceIzBaze = o.get();
                if(!serviceIzBaze.getAuthor().equals(service.getAuthor()))
                    throw new ForbiddenOperationException("Uporabnik, ki posodablja storitev ni prvotni avtor storitve");
            }
        }

        return serviceRepository.save(service);
    }
}
