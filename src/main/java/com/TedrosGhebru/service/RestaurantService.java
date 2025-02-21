package com.TedrosGhebru.service;

import com.TedrosGhebru.dto.RestaurantDto;
import com.TedrosGhebru.entity.Restaurant;
import com.TedrosGhebru.mapper.RestaurantMapper;
import com.TedrosGhebru.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        //map it to list of DTos. Remember we have added mapstruct dependency in pom for this task
      List<RestaurantDto> restaurantDtos = restaurants.stream().map(restaurant->RestaurantMapper.instance.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
        return restaurantDtos;
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
          Restaurant restaurant  = RestaurantMapper.instance.mapRestaurantDtoToRestaurant(restaurantDto);
              Restaurant restaurantFromDb    = restaurantRepo.save(restaurant);

              return RestaurantMapper.instance.mapRestaurantToRestaurantDto(restaurantFromDb);
    }

    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {

         Optional<Restaurant> restaurant    = restaurantRepo.findById(id);
         if(restaurant.isPresent()) {
         RestaurantDto restaurantDto    =RestaurantMapper.instance.mapRestaurantToRestaurantDto(restaurant.get());
             return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
         }
         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
