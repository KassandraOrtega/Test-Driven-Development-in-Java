package test.example;

import main.example.SimpleUserService;
import main.example.User;
import main.example.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestEmptyUserService {
    private UserService userService;
    private MockAuditLog mockAuditLog;
    private FakeUserStore fakeUserStore;
    private StubTimeSource stubTimeSource;

    @Before
    public void createUserService(){
        mockAuditLog = new MockAuditLog();
        fakeUserStore = new FakeUserStore();
        stubTimeSource = new StubTimeSource();
        userService = new SimpleUserService(mockAuditLog, fakeUserStore, stubTimeSource);
        mockAuditLog.enable();
    }

    @Test
    public void testDefaultServiceHasNoUsers(){
        assertEquals(0, userService.users().size());
    }

    @Test
    public void testFindingNonExistentUser(){
        assertNull(userService.find("bob"));
    }

    @Test
    public void testRegisteringSingleUser(){
        mockAuditLog.expect("user", "register", "bob");

        userService.register("bob");
        List<User> users = userService.users();

        assertEquals(1, users.size());
        assertEquals("bob", users.get(0).getUsername());
        assertEquals(stubTimeSource.currentTime(), users.get(0).getCreationTime());
        mockAuditLog.verify();
    }
}
