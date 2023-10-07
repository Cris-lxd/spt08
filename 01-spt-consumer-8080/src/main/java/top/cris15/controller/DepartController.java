package top.cris15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.cris15.bean.Depart;
import top.cris15.utils.R;

@RestController
@RequestMapping("consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String SERVICE_PROVIDER = "http://localhost:8081/provider/depart";

    @PostMapping("/save")
    public R saveHandle(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER +"/save";
        return restTemplate.postForObject(url,depart,R.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable int id){
        String url = SERVICE_PROVIDER + "/del/" + id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/update";
        restTemplate.put(url,depart);
    }

    @GetMapping("/get/{id}")
    public R getHandle(@PathVariable int id){
        String url = SERVICE_PROVIDER + "/get/" + id;
        return restTemplate.getForObject(url,R.class);
    }

    @GetMapping("/list")
    public R listHandle(){
        String url = SERVICE_PROVIDER + "/list";
        R r = restTemplate.getForObject(url,R.class);
        return r;
    }

}
