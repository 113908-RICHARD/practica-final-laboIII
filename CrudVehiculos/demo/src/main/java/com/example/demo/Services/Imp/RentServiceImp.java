package com.example.demo.Services.Imp;

import com.example.demo.Dtos.Rents.GetRentByDate.RentByDateRequest;
import com.example.demo.Dtos.Rents.GetRentByDate.RentByDateResponse;
import com.example.demo.Dtos.Rents.RentDTOupdate;
import com.example.demo.Dtos.Rents.rentDTO;
import com.example.demo.Enities.CarEntity;
import com.example.demo.Enities.RentEntity;
import com.example.demo.Models.Rent;
import com.example.demo.Repositories.CarJPArepository;
import com.example.demo.Repositories.RentJPArepository;
import com.example.demo.Services.RentService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class RentServiceImp implements RentService {

    @Autowired
    private RentJPArepository rentJPArepository;

    @Autowired
    private CarJPArepository carJPArepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Rent> getAllRents() {
        List<RentEntity> rentsE = rentJPArepository.findAll();
        List<Rent> rents  = new ArrayList<>();
        if (rentsE.isEmpty()){
            throw  new EntityNotFoundException();
        }
        for (RentEntity rent:rentsE
        ) {
            Rent rentToAdd = modelMapper.map(rent,Rent.class);
            rents.add(rentToAdd);

        }
        return rents;
    }

    @Override
    public Rent getRentById(Long id) {
        RentEntity rentEntity = rentJPArepository.getReferenceById( id);
        if(Objects.isNull(rentEntity)){
            throw  new EntityNotFoundException();
        }
        Rent rent = modelMapper.map(rentEntity,Rent.class);
        return rent;
    }

    @Override
    public Rent saveRent(rentDTO rent) {
       RentEntity rentToSave = new RentEntity();
       rentToSave.setCustomer(rent.getCustomer());
       CarEntity car = carJPArepository.getReferenceById(rent.getCar());
       rentToSave.setCar(car);
       rentToSave.setRentedDays(rent.getRentedDays());
       rentToSave.setStart_rent(rent.getStartRent());
       rentToSave.setEnd_rent(rent.getStartRent().plusDays(rent.getRentedDays()).truncatedTo(ChronoUnit.SECONDS)        );
       rentToSave.setTotalPrice(100 * rent.getRentedDays());
       rentJPArepository.save(rentToSave);
       return modelMapper.map(rentToSave,Rent.class);
    }

    @Override
    public Rent updateRent(RentDTOupdate rent) {
        return null;
    }

    @Override
    public Rent deleteRent(Long id) {
        return null;
    }

    @Override
    public RentByDateResponse getByDate(RentByDateRequest rent) {
       Long carId = rent.getCarId();
        LocalDateTime requestedDate = rent.getDateToAsk();

        // Get all rents associated with the car
        Optional<List<RentEntity>> rentsOptional = rentJPArepository.findByCarId(carId);
        RentByDateResponse respuesta = new RentByDateResponse();
        respuesta.setVehicleState("Vehiculo disponible");
        AtomicBoolean isAvaible = new AtomicBoolean(true);

        rentsOptional.ifPresent(rents -> {
            for (RentEntity rentEntity : rents) {
                LocalDateTime startRent = rentEntity.getStart_rent();


                // Calculate the end date of the rent (startRent + rentedDays)
                LocalDateTime endRent = rentEntity.getEnd_rent();

                // Check if the requested date falls within the rented days of any rent
                if (!requestedDate.isBefore(startRent) && !requestedDate.isAfter(endRent)) {
                    // Car is not available on the requested date
                    isAvaible.set(false);
                    respuesta.setVehicleState("vehiculo no disponible");
                }
            }
        });

        return respuesta;
        // Car is available on the requested date

    }
}




