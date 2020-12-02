import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uni.eszterhazy.keretrendszer.dao.HorgaszatDAO;
import uni.eszterhazy.keretrendszer.dao.json.HorgaszatDAOJSON;
import uni.eszterhazy.keretrendszer.dao.mongo.HorgaszatDAOMongo;
import uni.eszterhazy.keretrendszer.service.HorgaszatService;
import uni.eszterhazy.keretrendszer.service.impl.HorgaszatServiceImpl;

import java.io.IOException;
import java.net.UnknownHostException;

@Configuration
@ComponentScan({"uni.eszterhazy.keretrendszer.controller"})
public class MyConfig {

    @Bean(name="mongoDBDAO")
    public HorgaszatDAO mongodb(){
        try {
            return new HorgaszatDAOMongo("mongodb://localhost:31182", "horgaszatok","horgaszat");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Qualifier("jsonDBDAO")
    @Bean
    public HorgaszatDAO jsondb(){
        try{
            return new HorgaszatDAOJSON("Horgaszat.json");
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public HorgaszatService horgaszatService(HorgaszatDAO mongoDBDAO){
        return new HorgaszatServiceImpl(mongoDBDAO);
    }
}
