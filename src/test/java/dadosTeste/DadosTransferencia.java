package dadosTeste;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class DadosTransferencia {
    By botaoTransferencia = By.id("btn-TRANSFERÊNCIA");
    By campoNumeroConta = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input");
    By campoDigito = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[2]/input");
    By campoValor = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[2]/input");
    By campoDescricao = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/div[3]/input");
    By botaoTranferirAgora = By.xpath("//*[@id=\"__next\"]/div/div[3]/form/button");
    By botaoFechar = By.id("btnCloseModal");
    By tranferenciaOk = By.id("modalText");
    By botaoVoltar = By.id("btnBack");
}
