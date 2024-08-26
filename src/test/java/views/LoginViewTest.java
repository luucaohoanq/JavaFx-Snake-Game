package views;

import static org.junit.Assert.assertEquals;

import com.lcaohoanq.formhandling.modules.user.UserEntity;
import com.lcaohoanq.formhandling.utils.EnvUtils;
import com.lcaohoanq.formhandling.views.LoginView;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LoginViewTest {

    String email_phone;
    String password;
    private LoginView loginView;

    @Before
    public void setUp() throws Exception {
        loginView = new LoginView();
        this.email_phone = EnvUtils.get("TEST_EMAIL");
        this.password = EnvUtils.get("TEST_PASSWORD");
    }


    @Test
    @Ignore
    public void getDataWhenLogin() {
        UserEntity expectedResult = new UserEntity(email_phone, password);
        loginView.setLogin(email_phone, password);
        UserEntity actualResult = loginView.getDataWhenLogin();
        assertEquals(expectedResult, actualResult);
    }

}