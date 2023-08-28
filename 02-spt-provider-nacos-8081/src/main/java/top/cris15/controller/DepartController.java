package top.cris15.controller;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.cris15.bean.Depart;
import top.cris15.service.DepartService;
import top.cris15.utils.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService service;

    @Autowired
    private DiscoveryClient client;

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

    /**
     * 获取微服务的注册信息
     * @return
     */
    @GetMapping("/discovery")
    public R discoveryHandle(){
        // 获取注册中心注册表的所有服务名称
        List<String> services = client.getServices();
        services.forEach(o -> {
            // 获取指定微服务名称的所有微服务实例
            List<ServiceInstance> instances = client.getInstances(o);
            instances.forEach(instance ->{
                Map map = new HashMap();
                map.put("serviceName",o);
                map.put("serviceId",instance.getServiceId());
                map.put("serviceHost",instance.getHost());
                map.put("servicePort",instance.getPort());
                map.put("serviceUri",instance.getUri());
                System.out.println(map);
            });
        });
        return R.ok(services);
    }
}
