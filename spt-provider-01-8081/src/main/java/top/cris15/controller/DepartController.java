package top.cris15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cris15.bean.Depart;
import top.cris15.service.DepartService;
import top.cris15.utils.R;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService service;

    @PostMapping("/save")
    public R saveHandle(@RequestBody Depart depart){
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public R deleteHandle(@PathVariable("id") int id){
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public R updateHandle(@RequestBody Depart depart){
        return service.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public R getHandle(@PathVariable("id") int id){
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public R listHandle(){
        return service.listAllDeparts();
    }
}
