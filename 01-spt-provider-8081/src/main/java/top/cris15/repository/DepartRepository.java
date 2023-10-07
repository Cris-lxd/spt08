package top.cris15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import top.cris15.bean.Depart;

/**
 * date： 2023/8/22
 * time： 21:15
 * author： cris
 * description：
 **/

@Component
public interface DepartRepository extends JpaRepository<Depart,Integer> {
}
