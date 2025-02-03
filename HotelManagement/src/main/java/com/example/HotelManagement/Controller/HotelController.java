package com.example.HotelManagement.Controller;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
      @Autowired
      HotelService hotelService;

     @PostMapping("/createHotel")
     public ResponseEntity<Hotel> createHotel(@RequestBody HotelDTO hotelDTO){

         return hotelService.saveHotel(hotelDTO);
     }

     @GetMapping(path = "/getAllHotels")
     public List<Hotel> getAllHotels(){
           return hotelService.getAllHotels();
     }

     @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
     }

     @PutMapping("/updateHotel/{id}")
     public ResponseEntity<Hotel> updateHotel(@RequestBody HotelDTO hotelDTO,@PathVariable Long id){
        return  hotelService.updateHotel(hotelDTO,id);
     }

     @DeleteMapping("/deleteHotel/{id}")
     public ResponseEntity<String> deleteHotel(@PathVariable Long id){
         return hotelService.deleteHotel(id);
     }

     @PutMapping("/updateHotelAddress/{id}")
    public ResponseEntity<Hotel> updateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO, @PathVariable Long id){
        return  hotelService.updateHotelAddress(updateHotelAddressDTO,id);
    }
}
