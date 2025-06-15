public class HelloService {
    HelloDao helloDao;
    void say(){
        helloDao.say();
    }


     public void setHelloDao(HelloDao helloDao) { //必须public
        this.helloDao = helloDao;
    }

}


class HelloDao {
     void say(){
        System.out.println("dao says hello");
    }
}



