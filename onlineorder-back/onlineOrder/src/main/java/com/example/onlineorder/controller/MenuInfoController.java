package com.example.onlineorder.controller;

import com.example.onlineorder.entity.MenuItem;
import com.example.onlineorder.entity.Restaurant;
import com.example.onlineorder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

// this controller is used to return restaurants, or when users click certain restaurant, return the menu info
@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {

        return menuInfoService.getRestaurants();

    }

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {

        return menuInfoService.getAllMenuItem(restaurantId);
    }




}
