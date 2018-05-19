package person.mockdog.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import person.mockdog.dao.MockDao;

/**
 * 
 * @author huangwenjun
 * @Date 2018年3月6日
 *
 */
@Component
@Order(value = 1)
public class InitMockDB implements CommandLineRunner {

    @Autowired
    private MockDao MockDao;

    @Override
    public void run(String... args) throws Exception {
        // List<MockEntity> mockEntities = MockDao.list();
        // for (MockEntity temp : mockEntities) {
        // System.out.println("初始化mock DB:" + temp.toString());
        // List<MockEntity> mList = MockDb.mockDB.get(temp.getUri());
        // if (CollectionUtils.isEmpty(mList)) {
        // mList = new ArrayList<MockEntity>();
        // }
        // mList.add(temp);
        // MockDb.mockDB.put(temp.getUri(), mList);
        // }
    }
}
