package dadosTeste;


import lombok.Getter;
import org.openqa.selenium.By;

@Getter

public class DadosCadastro {
    By botaoRegistrar = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]");
    By campoEmailCadastro = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input");
    By campoNomeCadastro = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input");
    By campoSenhaCadastro = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input");
    By campoConfirmaSenhaCadastro = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input");
    By labelSaldo = By.xpath("//*[@id=\"toggleAddBalance\"]");
    By labelCriarComSaldo = By.id("toggleAddBalance");
    By botaoCadastrar = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button");
    By botaoFechar = By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[1]/a");
    By botaoVoltar = By.id("#btnBackButton");
    By modal = By.xpath("//*[@id=\"modalText\"]");
}
