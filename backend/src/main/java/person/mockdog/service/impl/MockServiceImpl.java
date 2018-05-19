package person.mockdog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.mockdog.dao.MockDao;
import person.mockdog.dto.ReturnInfo;
import person.mockdog.entity.MockEntity;
import person.mockdog.service.MockService;

@Service
public class MockServiceImpl implements MockService {

    @Autowired
    private MockDao mockDao;

    @Override
    public ReturnInfo mockList() {
        List<MockEntity> mockEntities = mockDao.list();
        return ReturnInfo.createReturnSuccessOne(mockEntities);
    }

    @Override
    public ReturnInfo mockAdd(MockEntity mockEntity) {
        int result = mockDao.insert(mockEntity);
        return ReturnInfo.createReturnSuccessOne(result);
    }

    @Override
    public ReturnInfo mockDel(int mockId) {
        int result = mockDao.delete(mockId);
        return ReturnInfo.createReturnSuccessOne(result);
    }

    @Override
    public ReturnInfo mockUpdate(MockEntity mockEntity) {
        int result = mockDao.update(mockEntity);
        return ReturnInfo.createReturnSuccessOne(result);
    }
}
