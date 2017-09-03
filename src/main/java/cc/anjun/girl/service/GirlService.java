package cc.anjun.girl.service;

import cc.anjun.girl.domain.Girl;
import cc.anjun.girl.enums.ResultEnum;
import cc.anjun.girl.exception.GirlException;
import cc.anjun.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class GirlService {
    @Autowired
    public GirlRepository girlRepository;
    @Transactional
    public void insertTwoGirl(){
        Girl girl = new Girl();
        girl.setAge(19);
        girl.setCupSize("F");
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setAge(29);
        girl2.setCupSize("Dff");
        girlRepository.save(girl2);
    }
    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        if(girl.getAge()>50){
            throw  new GirlException(ResultEnum.TOO_BIG);
        }else if(girl.getAge()<10){
            throw new GirlException(ResultEnum.TOO_SMALL);
        }
    }
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
