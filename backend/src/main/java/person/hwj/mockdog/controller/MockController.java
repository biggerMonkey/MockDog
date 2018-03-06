package person.hwj.mockdog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import person.hwj.mockdog.dto.ReturnInfo;
import person.hwj.mockdog.entity.MockEntity;
import person.hwj.mockdog.service.MockService;

@RestController
@RequestMapping("/mock")
public class MockController {

    @Autowired
    private MockService mockService;

    @PostMapping("/add")
    public ReturnInfo mockAdd(@RequestBody MockEntity mockEntity) {
        return mockService.mockAdd(mockEntity);
    }

    @PostMapping("/list")
    public ReturnInfo mockList() {
        return mockService.mockList();
    }

    @DeleteMapping("/del/{mock-id}")
    public ReturnInfo mockDel(@PathVariable("mock-id") int mockId) {
        return mockService.mockDel(mockId);
    }

    @PutMapping("/update")
    public ReturnInfo mockUpdate(@RequestBody MockEntity mockEntity) {
        return mockService.mockUpdate(mockEntity);
    }


}
