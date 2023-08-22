package top.cris15.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import top.cris15.bean.Depart;
import top.cris15.repository.DepartRepository;
import top.cris15.service.DepartService;
import top.cris15.utils.R;

import java.util.List;

/**
 * date： 2023/8/22
 * time： 21:20
 * author： cris
 * description：
 **/

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository departRepository;
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
        if(departRepository.existsById(id)){
            departRepository.findById(id);
            return R.ok();
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return R.ok(depart);
    }

    @Override
    public R listAllDeparts() {
        return R.ok();
    }
}
