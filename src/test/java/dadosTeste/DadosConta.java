package dadosTeste;

import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class DadosConta {
    By numeroConta = By.id("textAccountNumber");
    By saldoConta = By.xpath("//*[@id=\"textBalance\"]/span");
}
