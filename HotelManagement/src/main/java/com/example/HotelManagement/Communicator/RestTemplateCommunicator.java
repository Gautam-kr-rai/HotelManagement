package com.example.HotelManagement.Communicator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import static org.springframework.web.client.RestClientUtils.getBody;
@Service
public class RestTemplateCommunicator {

    private final RestTemplate restTemplate;

//    @Autowired
//    public RestTemplateCommunicator(RestTemplateBuilder restTemplateBuilder){
//        this.restTemplate = restTemplateBuilder.build();
//    }

    public RestTemplateCommunicator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Float getActualHotelRating(Long hotelId){

        String url = "http://localhost:8084/rating/getRatingByHotelId/"+ hotelId;

        ResponseEntity<Float> hotelRating = restTemplate.getForEntity(url, Float.class);
        return hotelRating.getBody();
    }
}
