package dadosTeste;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DadosLogin {
    By campoEmail = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input");
    By campoSenha = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input");
    By botaoAvancar = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]");
    By botaoLogout = By.id("btnExit");
}
