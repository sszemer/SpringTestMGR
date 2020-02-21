package com.example.servingwebcontent;

import POJO.TestPOJO;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class AllController {

    @GetMapping("/all")
    public String showTests(@RequestParam(name="status", required=false, defaultValue="") String name, Model model) {
        model.addAttribute("tests", MongoConnection.getInstance().findAll(TestPOJO.class).stream().filter(testPOJO -> testPOJO.getResult().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList()));
        return "all";
    }

    @PostMapping("/all")
    @ResponseBody
    public String runTests(@RequestParam(name="id") String[] tests, @RequestParam(name="status") String status) {
        for (String test : tests) {
            MongoConnection.getInstance().findAll(TestPOJO.class).stream().filter(testPOJO -> testPOJO.getId().equalsIgnoreCase(test)).collect(Collectors.toList())
                    .forEach(testPOJO -> {
                        testPOJO.setResult(status);
                        MongoConnection.getInstance().save(testPOJO);
                    });
        }
        return "Changed status of " + Arrays.stream(tests).collect(Collectors.toList()) + " to " + status;
    }
}