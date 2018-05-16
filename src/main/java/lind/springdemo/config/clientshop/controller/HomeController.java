package lind.springdemo.config.clientshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Autowired
  private Environment profile;

  @RequestMapping("/")
  public String index(@RequestParam String key) {

    return key + "=" + profile.getProperty(key);
  }
}
