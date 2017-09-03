package cc.anjun.girl.controller;

import cc.anjun.girl.domain.Girl;
import cc.anjun.girl.domain.Result;
import cc.anjun.girl.repository.GirlRepository;
import cc.anjun.girl.service.GirlService;
import cc.anjun.girl.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class GirlController {
    @Autowired
    GirlRepository girlRepository;
    @Autowired
    GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> all() {
        System.out.println("all()");
        return girlRepository.findAll();
    }

    @GetMapping("/girls/{id}")
    public Girl one(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PostMapping("/girls")
    public Result<Girl> addGirl(@Valid  Girl girl, BindingResult result) {
        log.debug("girlpost:{}",girl);
        if (result.hasErrors()) {
            return ResultUtil.error(1, result.getFieldError().getDefaultMessage());
        }
        log.error("bindingResult:{}", result);
        return ResultUtil.sucess(girlRepository.save(girl));

    }

    @PutMapping("/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    @DeleteMapping("girls/{id}")
    public void del(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void addGirl2() {

        girlService.insertTwoGirl();
    }

    @GetMapping("/girls/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
