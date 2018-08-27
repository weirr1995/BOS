package cn.cl.bos.service.base;

import cn.cl.bos.dao.base.CourierRepository;
import cn.cl.bos.domain.base.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourierServiceImpl implements CourierService {
    @Override
    public Page<Courier> findPageData(Specification<Courier> specification,Pageable pageable) {
        return courierRepository.findAll(specification,pageable);
    }

    @Override
    public void delBath(String[] ids) {
        for (String idStr : ids) {
            Integer id = Integer.parseInt(idStr);
            courierRepository.updateDelTag1(id);
        }
    }

    @Override
    public void restoreBatch(String[] idArray) {
        for (String idStr : idArray) {
            Integer id = Integer.parseInt(idStr);
            courierRepository.updateDelTag0(id);
        }
    }

    @Autowired
    private CourierRepository courierRepository;

    @Override
    public void save(Courier courier) {
        courierRepository.save(courier);
    }
}
