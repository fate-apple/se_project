package com.se.Service.Auth;

<<<<<<< HEAD
import com.se.Domain.Bussiness.User;
=======
import com.se.Domain.Business.User;
>>>>>>> cf14035ebec2295d395762a50c1696656ddd5378

/**
 * Created by clevo on 2017/7/11.
 */
public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
