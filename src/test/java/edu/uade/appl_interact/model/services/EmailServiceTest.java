package test.java.edu.uade.appl_interact.model.services;

import edu.uade.appl_interact.data_access.dao.impl.GiftListDao;
import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;
import edu.uade.appl_interact.data_access.dao.impl.UserDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.EmailService;
import edu.uade.appl_interact.workers.EndingListWorker;
import edu.uade.lib.Helper;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;

public class EmailServiceTest {

    private User user;
    private User user2;
    private Subscription subscription;
    private Subscription subscription2;
    private GiftList giftList1;


    @Before
    public void setUp() throws Exception {
        try {
            List<GiftList> result = GiftListDao.getInstance().findManyBy("due_date", Helper.fromDate(Helper.tomorrow()));

            for (Iterator<GiftList> i = result.iterator(); i.hasNext(); ) {
                GiftListDao.getInstance().delete(i.next().getId());
            }
            init();
        } catch (Exception e) {
        }
    }

    @Test
    public void dueDate() throws Exception {
        EmailService.getInstance().dueDateEmail(giftList1);

    }

    private void init() throws Exception {
        user = new User();
        user.setName("matiasberruet");
        user.setEmail("matiasberruet@gmail.com");
        Integer tmpId = UserDao.getInstance().create(user);
        user.setId(tmpId);

        user2 = new User();
        user2.setName("mariano.grimaux");
        user2.setEmail("mariano.grimaux@gmail.com");
        tmpId = UserDao.getInstance().create(user2);
        user2.setId(tmpId);

        subscription = new Subscription();
        subscription.setUser(user);

        subscription2 = new Subscription();
        subscription2.setUser(user2);


        giftList1 = new GiftList();
        giftList1.setListName("endTomorrow1");
        giftList1.setDueDate(Helper.tomorrow());
        giftList1.setOwner(dummyUser());
        tmpId = GiftListDao.getInstance().create(giftList1);
        giftList1.setId(tmpId);

        giftList1.addGifter(subscription);
        giftList1.addGifter(subscription2);

        List<Subscription> result = SubscriptionDao.getInstance().saveSubscriptions(giftList1);
        subscription = result.get(0);
        subscription2 = result.get(1);
    }

    public User dummyUser() {
        User tmp = new User();
        tmp.setId(1);
        tmp.setEmail("dberrueta@uade.edu.ar");
        return tmp;
    }
}