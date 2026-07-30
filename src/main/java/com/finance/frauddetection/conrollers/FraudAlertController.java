package com.finance.frauddetection.conrollers;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {
    @GetMapping()
    public String getAll(){
        return "Get All Transcations";
    }

    @PutMapping ("/{id}/status")
    public String updateStatus(@PathVariable int id){
        return "Update status"  + id;
    }


}
