package person.mockdog.service;

import person.mockdog.dto.ReturnInfo;
import person.mockdog.entity.MockEntity;

public interface MockService {
    public ReturnInfo mockAdd(MockEntity mockEntity);

    public ReturnInfo mockDel(int mockId);

    public ReturnInfo mockList();

    public ReturnInfo mockUpdate(MockEntity mockEntity);

}
