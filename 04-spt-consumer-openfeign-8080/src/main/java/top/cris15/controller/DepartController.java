package top.cris15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.cris15.bean.Depart;
import top.cris15.service.DepartService;
import top.cris15.utils.R;

@RestController
@RequestMapping("consumer/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public R saveHandle(@RequestBody Depart depart){
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public R deleteHandle(@PathVariable int id){
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public R updateHandle(@RequestBody Depart depart){
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public R getHandle(@PathVariable int id){
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public R listHandle(){
        return departService.listAllDeparts();
    }

}
