package com.example.HotelManagement.Services;

import com.example.HotelManagement.Communicator.RestTemplateCommunicator;
import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final RestTemplateCommunicator restTemplateCommunicator;



    @Autowired
    public HotelService(HotelRepository hotelRepository, RestTemplateCommunicator restTemplateCommunicator) {
        this.hotelRepository = hotelRepository;
        this.restTemplateCommunicator = restTemplateCommunicator;
    }

    public ResponseEntity<Hotel> saveHotel(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setCity(hotelDTO.getCity());
        hotel.setPostalCode(hotelDTO.getPostalCode());
        hotel.setRating(hotelDTO.getRating());
        hotel.setAvailable(hotelDTO.isAvailable());

        hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public ResponseEntity<Hotel> getHotelById(Long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);

        if (hotelBox.isPresent()) {
            Hotel hotel = hotelBox.get();
            Float hotelActualRating = restTemplateCommunicator.getActualHotelRating(id);
            hotel.setRating(hotelActualRating);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Hotel> updateHotel(HotelDTO hotelDTO, Long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);

        if (hotelBox.isPresent()) {
            Hotel hotel = hotelBox.get();
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotel.setCity(hotelDTO.getCity());
            hotel.setPostalCode(hotelDTO.getPostalCode());
            hotel.setRating(hotelDTO.getRating());
            hotel.setAvailable(hotelDTO.isAvailable());

            hotelRepository.save(hotel);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteHotel(Long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);

        if (hotelBox.isPresent()) {
            hotelRepository.deleteById(id);
            return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Hotel not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Hotel> updateHotelAddress(UpdateHotelAddressDTO updateHotelAddressDTO, Long id) {
        Optional<Hotel> hotelBox = hotelRepository.findById(id);

        if (hotelBox.isPresent()) {
            Hotel hotel = hotelBox.get();
            hotel.setAddress(updateHotelAddressDTO.getAddress());
            hotel.setCity(updateHotelAddressDTO.getCity());
            hotel.setPostalCode(updateHotelAddressDTO.getPostalCode());

            hotelRepository.save(hotel);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
