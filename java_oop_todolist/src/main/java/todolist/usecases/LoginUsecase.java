package todolist.usecases;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.userEntitiy;
import todolist.models.loginModels;
import todolist.utils.DBConnectionUtil;

public class LoginUsecase {
    private HikariDataSource dataSource;

    private loginModels loginModels ;

    public LoginUsecase() {
        dataSource = DBConnectionUtil.getDataSource();
        loginModels = new loginModels(dataSource);
    }
    public String LoginValidate(String userid, String password) {
        // Validasi input tidak boleh kosong
        if (userid.equals("")|| password.equals("")) {
            return "userid and password cannot be empty!";
        }

        userEntitiy user = new userEntitiy();
        user.setUserId(userid);
        user.setPassword(password);

        // Validasi user exists pada DB
        if (!loginModels.CheckUserExists(user.getUserid())) {
            return "userid is not exists, please try again.";
        }
    
        // Validasi userid & password valid
        if (!loginModels.UserPasswordValid(user)) {
            return "userid and password is not valid, please try again";
        }
        return "";
    }
}
