package top.cris15.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.cris15.bean.Depart;
import top.cris15.utils.R;

/**
 * date： 2023/10/9
 * time： 21:36
 * author： cris
 * description：
 **/

@FeignClient(value = "depart-provider", path = "/provider/depart")
public interface DepartService {


    @PostMapping("/save")
    R saveDepart(@RequestBody Depart depart);

    @DeleteMapping("/del/{id}")
    R removeDepartById(@PathVariable int id);

    @PutMapping("/update")
    R modifyDepart(@RequestBody Depart depart);

    @GetMapping("/get/{id}")
    R getDepartById(@PathVariable int id);

    @GetMapping("/list")
    R listAllDeparts();
}
