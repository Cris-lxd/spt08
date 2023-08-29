package top.cris15.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cris15.bean.Depart;
import top.cris15.repository.DepartRepository;
import top.cris15.service.DepartService;
import top.cris15.utils.R;

import java.util.List;
import java.util.Optional;

/**
 * date： 2023/8/22
 * time： 21:20
 * author： cris
 * description：
 **/

@Service
@Transactional(rollbackFor = Exception.class)
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository departRepository;

    @Value("${server.port}")
    private int port;

    @Override
    public R saveDepart(Depart depart) {
        Depart save = departRepository.save(depart);
        return save == null ? R.fail():R.ok();
    }

    @Override
    public R removeDepartById(int id) {
        if(departRepository.existsById(id)){
            departRepository.deleteById(id);
            return R.ok();
        }
        return R.fail();
    }

    @Override
    public R modifyDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        return obj == null ? R.fail(): R.ok();
    }

    @Override
    public R getDepartById(int id) {
        Depart depart;
        if(departRepository.existsById(id)){
            Optional<Depart> depart1 = departRepository.findById(id);
            depart = depart1.get();
        }else{
            depart = new Depart();
            depart.setName("no this depart" + port);
        }
        return R.ok(depart);
    }

    @Override
    public R listAllDeparts() {
        List<Depart> all = departRepository.findAll();
        return R.ok(all);
    }
}
