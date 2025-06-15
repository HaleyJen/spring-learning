public class UserDao {
    void addUser(){
        System.out.println("add user");
    }
    void  delUser(){
        System.out.println("delete user");
    }
}

class DaoAspect{
    void check_Permission(){
        System.out.println("before check permission...");
    }
    void log(){
        System.out.println("after record log...");
    }

}
