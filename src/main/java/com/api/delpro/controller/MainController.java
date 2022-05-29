package com.api.delpro.controller;


import com.api.delpro.model.dto.DeliveryDTO;
import com.api.delpro.model.dto.SearchDTO;
import com.api.delpro.service.CityService;
import com.api.delpro.service.OrderService;
import com.api.delpro.service.RegionService;
import com.api.delpro.service.SearchServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class MainController {
    private final RegionService regionService;
    private final CityService cityService;
    private final OrderService orderService;
    private final SearchServiceImpl searchService;

    public MainController(RegionService regionService, CityService cityService, OrderService orderService, SearchServiceImpl searchService) {
        this.regionService = regionService;
        this.cityService = cityService;
        this.orderService = orderService;
        this.searchService = searchService;
    }

//    @GetMapping
//    public String index(Model model){
//        model.addAttribute("order", new Order());
//        model.addAttribute("region", regionService.regionList());
//        model.addAttribute("city", cityService.cityList());
//        return "index";
//    }
//    @PostMapping("/save")
//    public String saveOrder(Order order){
//        orderService.save(order);
//        return "redirect:/";
//    }
    @GetMapping
    public String index(Model model, SearchDTO searchDTO){
        model.addAttribute("search", new SearchDTO());
        List<DeliveryDTO> deliveryDTOList = searchService.search(searchDTO);
        model.addAttribute("delivery", deliveryDTOList);
        return "index";
    }
    @GetMapping("/filter")
    public String filter(Model model, SearchDTO searchDTO){
        List<DeliveryDTO> deliveryDTOList = searchService.search(searchDTO);
        model.addAttribute("delivery", deliveryDTOList);
        return "results";
    }
}
