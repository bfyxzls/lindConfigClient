package lind.springdemo.config.clientshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @Value("${server.port}") // git配置文件里的key
      String serverPort;

  @RequestMapping("/")
  public String index() {
    return "serverPort=" + serverPort;
  }
}
