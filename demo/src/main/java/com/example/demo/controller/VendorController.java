package com.example.demo.controller;

import com.example.demo.Entity.Vendors;
import com.example.demo.service.VendorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/vendor")
public class VendorController {
    private final VendorServices vendorServices;
    @Autowired
    public VendorController(VendorServices vendorServices) {
        this.vendorServices = vendorServices;
    }

    @GetMapping
    public List<Vendors> hello(){
        return vendorServices.getVendor();

    }
    @PostMapping
    public void registerNewWorker(@RequestBody Vendors vendor){

        vendorServices.addVendor(vendor);
    }
    @DeleteMapping(path = "{ids}")
    public void deleteEvent(@PathVariable("ids")Long ids){
        vendorServices.deleteVendor(ids);
    }
    @GetMapping("/get/{id}")
    public Optional<Vendors> getOneGuest(@PathVariable("id")Long id){
        return vendorServices.getOneVendor(id);

    }
    @PutMapping(path ="/update/{id}" )
    public void updateGuest(
            @PathVariable("id") Long id,
            @RequestParam(required = false)String services,
            @RequestParam(required = false)String name){
        vendorServices.updateVendor(id,services,name);
    }

}
