package com.first.demo.rest;


import com.first.demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

    private Coach myCoach;

    @Autowired
    DemoController(@Qualifier("baseballCoach") Coach myCoach){
        this.myCoach = myCoach;
    }

    @GetMapping("/getdailyworkout")
    public String getCoach(){
        return myCoach.getDailyWorkout();
    }
}
