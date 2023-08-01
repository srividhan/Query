package com.example.QueryAnnotation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QueryAnnotation.model.Queries;
import com.example.QueryAnnotation.service.QueryService;

@RestController
@RequestMapping("/queryAnnotation")
public class QueryController {
    @Autowired
    QueryService queryService;
    @GetMapping("/show")
    public List<Queries> getDetails(){
        return queryService.getTableDatas();
    }

    @GetMapping("/showData")
    public List<Queries> getdetail(){
        return queryService.getTableData();
    }

    @GetMapping("/showData/{activeState}/{descriptionList}")
    public List<Queries> getData(@PathVariable Boolean activeState, @PathVariable List<String> descriptionList){
        return queryService.getDetail(activeState, descriptionList);
    }
    @PutMapping("/updateData/{activeState}/{idList}")
    public int updateData(@PathVariable Boolean activeState, @PathVariable List<Long> idList){
        return queryService.updateDatas(activeState, idList);
    }

}
