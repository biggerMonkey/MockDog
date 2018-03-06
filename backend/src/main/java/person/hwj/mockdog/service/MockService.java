package person.hwj.mockdog.service;

import person.hwj.mockdog.dto.ReturnInfo;
import person.hwj.mockdog.entity.MockEntity;

public interface MockService {
    public ReturnInfo mockAdd(MockEntity mockEntity);

    public ReturnInfo mockDel(int mockId);

    public ReturnInfo mockList();

    public ReturnInfo mockUpdate(MockEntity mockEntity);

}
