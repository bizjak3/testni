package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.LocationRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServices {
    private final ServiceRepository serviceRepository;
    private final LocationRepository locationRepository;

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

        service = serviceRepository.save(service);

        ServiceEntity finalService = service;
        service.setLocations(
                CollectionUtils.emptyIfNull(service.getLocations()).stream()
                    .filter(Objects::nonNull)
                    .peek(e -> e.setService(finalService))
                    .map(locationRepository::save)
                    .collect(Collectors.toSet())
        );

        return serviceRepository.save(service);
    }

    public List<ServiceEntity> getAllActiveServices() {
        return serviceRepository.findActiveServicesAtDate(LocalDateTime.now());
    }

    public List<ServiceEntity> getAllUsersServices(UserEntity user) {
        return serviceRepository.findByAuthor(user);
    }

    public List<ServiceEntity> getALlOrderedServices(UserEntity user) {
        return serviceRepository.findAllOrderedServices(user.getId());
    }

    public List<ServiceEntity> getALlSelectedServices(UserEntity user) {
        return serviceRepository.findAllSelectedServices(user.getId());
    }

    public UserEntity getPerson(UserEntity user) {
        if(serviceRepository.findPersonWhoOrdered(user.getId()).isPresent()) {
            return serviceRepository.findPersonWhoOrdered(user.getId()).get();
        }
        else return null;
    }

    public UserEntity findPerson(Integer id) {
        if(serviceRepository.findPerson(id).isPresent()) {
            return serviceRepository.findPerson(id).get();
        }
        else return null;
    }
}
