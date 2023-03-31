package com.example.demo.service;

import com.example.demo.Entity.Vendors;
import com.example.demo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VendorServices {
    @Autowired
    public VendorServices(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    private final VendorRepository vendorRepository;

    @Transactional
    public void updateVendor(Long ids,
                            String services,
                            String name) {
        Vendors workz=vendorRepository.findById(ids)
                .orElseThrow(()->new IllegalStateException(
                        "vendor with id "+ ids +" does not exist in database"));
        if (services!=null && services.length() >0 && !Objects.equals(workz.getServices(),services)) {
            workz.setServices(services);
        }
        if(name!=null&&name.length()>0 && !Objects.equals(workz.getName(),name)){
            workz.setName(name);
        }
    }

    public  void deleteVendor(Long ids) {
        vendorRepository.findById(ids);
        boolean exists = vendorRepository.existsById(ids);
        if (!exists){
            throw new IllegalStateException(
                    "vendor with id "+ ids +" does not exist in database"
            );}
        vendorRepository.deleteById(ids);

    }

    public void addVendor(Vendors vendors) {
        Optional<Vendors> workeroptional= vendorRepository.findVendorsByEmail(vendors.getName());
        if(workeroptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        vendorRepository.save(vendors);
    }

    public List<Vendors> getVendor() {
        return vendorRepository.findAll();
    }

    public Optional<Vendors> getOneVendor(Long workerID) {

        return vendorRepository.findById(workerID);
    }

}


