package top.cris15.service;

import top.cris15.bean.Depart;
import top.cris15.utils.R;

import java.util.List;

/**
 * date： 2023/8/22
 * time： 21:18
 * author： cris
 * description：
 **/
public interface DepartService {

    R saveDepart(Depart depart);

    R removeDepartById(int id);

    R modifyDepart(Depart depart);

    R getDepartById(int id);

    R listAllDeparts();
}
