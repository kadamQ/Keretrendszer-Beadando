import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uni.eszterhazy.keretrendszer.controller.HorgaszatController;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;

public class MyApp {
    public static void main(String[] args) {
        /*ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        HorgaszatDAO dao = (HorgaszatDAO) context.getBean("mongodb");
        System.out.println(dao.readAllHorgaszat());
        HorgaszatService service = (HorgaszatService) context.getBean("horgaszatService");
        System.out.println(service.getAllHorgaszat());
        HorgaszatController controller = (HorgaszatController) context.getBean("horgaszatController");
        controller.printAll();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        HorgaszatService service = (HorgaszatService) context.getBean("horgaszatService");
        System.out.println(service.getAllHorgaszat());


    }
}
