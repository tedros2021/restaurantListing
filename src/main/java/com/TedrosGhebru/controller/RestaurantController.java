package com.TedrosGhebru.controller;

import com.TedrosGhebru.dto.RestaurantDto;
import com.TedrosGhebru.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restaurants")
@CrossOrigin(origins = "*")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    @GetMapping()
    public ResponseEntity<List<RestaurantDto>> findAllRestaurants() {
        List<RestaurantDto> restaurantDtos  = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDtos, HttpStatus.OK);
    }


//    @PostMapping()
//    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
//
//       return new ResponseEntity<>(restaurantService.addRestaurant(restaurantDto),HttpStatus.CREATED);
//    }

    @PostMapping()
    public RestaurantDto saveRestaurant(@RequestBody RestaurantDto restaurantDto) {

        return restaurantService.addRestaurant(restaurantDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findRestaurantById(@PathVariable("id") Integer id) {
            return restaurantService.fetchRestaurantById(id);

    }
}
