package edu.uade.appl_interact.workers;

import edu.uade.appl_interact.data_access.dao.impl.GiftListDao;
import edu.uade.appl_interact.data_access.dao.impl.SubscriptionDao;
import edu.uade.appl_interact.data_access.dao.impl.UserDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Subscription;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.EmailService;
import edu.uade.lib.Helper;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EndingListWorkerTest {
    private EmailService emailService;
    private EndingListWorker endingListWorker;
    private User user;
    private User user2;
    private Subscription subscription;
    private Subscription subscription2;
    private GiftList giftList1;
    private GiftList giftList2;

    @Before
    public void setUp() throws Exception {
        emailService = mock(EmailService.class);
        endingListWorker = EndingListWorker.getInstance();
        endingListWorker.setEmailService(emailService);

        try {
            List<GiftList> result = GiftListDao.getInstance().findManyBy("due_date", Helper.fromDate(Helper.tomorrow()));

            for (Iterator<GiftList> i = result.iterator(); i.hasNext(); ) {
                GiftListDao.getInstance().delete(i.next().getId());
            }
        } catch (Exception e) {
        }
    }

    @Test
    public void run() throws Exception {
        init();

        String result = endingListWorker.run();
        assertEquals("", result);
        verify(emailService, times(2)).dueDateEmail(any(GiftList.class));
    }

    @Test
    public void runNoList() throws Exception {
        String result = endingListWorker.run();
        assertEquals("", result);
        verify(emailService, times(0)).dueDateEmail(any(GiftList.class));
    }

    private void init() throws Exception {
        user = new User();
        user.setName("qwerty");
        Integer tmpId = UserDao.getInstance().create(user);
        user.setId(tmpId);

        user2 = new User();
        user2.setName("abcdef");
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

        giftList2 = new GiftList();
        giftList2.setListName("endTomorrow2");
        giftList2.setDueDate(Helper.tomorrow());
        giftList2.setOwner(dummyUser());
        tmpId = GiftListDao.getInstance().create(giftList2);
        giftList2.setId(tmpId);

        GiftList giftList3 = new GiftList();
        giftList3.setListName("end1week");
        giftList3.setDueDate(Helper.addDays(7));
        giftList3.setOwner(dummyUser());
        tmpId = GiftListDao.getInstance().create(giftList3);
        giftList3.setId(tmpId);

        GiftList giftList4 = new GiftList();
        giftList4.setListName("passedDate");
        giftList4.setDueDate(Helper.addDays(-12));
        giftList4.setOwner(dummyUser());
        tmpId = GiftListDao.getInstance().create(giftList4);
        giftList4.setId(tmpId);

        giftList1.addGifter(subscription);
        giftList1.addGifter(subscription2);

        giftList2.addGifter(subscription);
        giftList2.addGifter(subscription2);

        giftList3.addGifter(subscription);
        giftList3.addGifter(subscription2);

        giftList4.addGifter(subscription);
        giftList4.addGifter(subscription2);

        SubscriptionDao.getInstance().saveSubscriptions(giftList1);
        SubscriptionDao.getInstance().saveSubscriptions(giftList2);
        SubscriptionDao.getInstance().saveSubscriptions(giftList3);
        SubscriptionDao.getInstance().saveSubscriptions(giftList4);
    }

    public User dummyUser() {
        User tmp = new User();
        tmp.setId(1);
        return tmp;
    }
}