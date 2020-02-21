package com.example.servingwebcontent;

import POJO.TestPOJO;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String greeting(Model model) {

        model.addAttribute("failed", MongoConnection.getInstance().findAll(TestPOJO.class).stream().filter(testPOJO -> testPOJO.getResult().equalsIgnoreCase("failed")).count());
        model.addAttribute("passed", MongoConnection.getInstance().findAll(TestPOJO.class).stream().filter(testPOJO -> testPOJO.getResult().equalsIgnoreCase("passed")).count());
        model.addAttribute("unexecuted", MongoConnection.getInstance().findAll(TestPOJO.class).stream().filter(testPOJO -> testPOJO.getResult().equalsIgnoreCase("unexecuted")).count());
        model.addAttribute("queued", MongoConnection.getInstance().findAll(TestPOJO.class).stream().filter(testPOJO -> testPOJO.getResult().equalsIgnoreCase("queued")).count());
        model.addAttribute("total", MongoConnection.getInstance().findAll(TestPOJO.class).size());
        return "dashboard";
    }

}