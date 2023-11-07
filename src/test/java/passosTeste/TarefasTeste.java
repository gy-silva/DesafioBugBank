package passosTeste;

import dadosTeste.DadosCadastro;
import dadosTeste.DadosLogin;
import dadosTeste.DadosConta;
import dadosTeste.DadosTransferencia;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class TarefasTeste {

    DadosLogin login = new DadosLogin();
    WebDriver browser  = new ChromeDriver();

    private int numeroDaConta = 0;
    private int numeroDigito = 0;

    public void abrirSite() {
        browser.navigate().to("https://bugbank.netlify.app/");
        browser.manage().window().maximize();

    }

    public void registroAtividades() throws InterruptedException {
        abrirSite();
        cadastrarUsuarioContaUm();
        browser.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        cadastrarUsuarioContaDois();
        acessarRealizarTransferencia();
        validarEntrada();
        browser.quit();
    }

    public void cadastrarUsuarioContaUm() throws InterruptedException {
        DadosCadastro dadosCadastro = new DadosCadastro();
        browser.findElement(dadosCadastro.getBotaoRegistrar()).click();

        browser.findElement(dadosCadastro.getCampoEmailCadastro()).sendKeys("ron.weasley@gmail.com");
        browser.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        browser.findElement(dadosCadastro.getCampoNomeCadastro()).sendKeys("Ron Weasley");
        browser.findElement(dadosCadastro.getCampoSenhaCadastro()).sendKeys("teste123");
        browser.findElement(dadosCadastro.getCampoConfirmaSenhaCadastro()).sendKeys("teste123");

        Thread.sleep(2000);
        browser.findElement(dadosCadastro.getLabelSaldo()).click();

        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.findElement(dadosCadastro.getBotaoCadastrar()).click();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.findElement(dadosCadastro.getBotaoFechar()).click();


        browser.findElement(login.getCampoEmail()).sendKeys("ron.weasley@gmail.com");
        browser.findElement(login.getCampoSenha()).sendKeys("teste123");
        browser.findElement(login.getBotaoAvancar()).click();
        extrairNumeroDaFrase();
        browser.findElement(login.getBotaoLogout()).click();
    }

    public void cadastrarUsuarioContaDois() throws InterruptedException {
        DadosCadastro dadosCadastro = new DadosCadastro();
        browser.findElement(dadosCadastro.getBotaoRegistrar()).click();

        browser.findElement(dadosCadastro.getCampoEmailCadastro()).sendKeys("harry.potter@gmail.com");
        browser.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        browser.findElement(dadosCadastro.getCampoNomeCadastro()).sendKeys("Harry Potter");
        browser.findElement(dadosCadastro.getCampoSenhaCadastro()).sendKeys("123teste");
        browser.findElement(dadosCadastro.getCampoConfirmaSenhaCadastro()).sendKeys("123teste");

        Thread.sleep(2000);
        browser.findElement(dadosCadastro.getLabelCriarComSaldo()).click();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.findElement(dadosCadastro.getBotaoCadastrar()).click();
        browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        browser.findElement(dadosCadastro.getBotaoFechar()).click();


        browser.findElement(login.getCampoEmail()).sendKeys("harry.potter@gmail.com");
        browser.findElement(login.getCampoSenha()).sendKeys("123teste");
        browser.findElement(login.getBotaoAvancar()).click();
        extrairNumeroDaFrase();
        browser.findElement(login.getBotaoLogout()).click();
    }

    private ExtrairNumeros extrairNumeroDaFrase() {
        DadosConta numero = new DadosConta();

        String texto = browser.findElement(numero.getNumeroConta()).getText();
        String campoFormatado = "(\\d{2,3})-(\\d{1})";

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(campoFormatado);
        java.util.regex.Matcher matcher = pattern.matcher(texto);

        if (matcher.find()) {
            numeroDaConta = Integer.parseInt(matcher.group(1));
            numeroDigito = Integer.parseInt(matcher.group(2));

            System.out.println("Número da Conta: " + numeroDaConta);
            System.out.println("Digito da Conta: " + numeroDigito);
        } else {
            System.out.println("Não encontrado");
        }
        return new ExtrairNumeros(numeroDaConta, numeroDigito);
    }

    public void acessarRealizarTransferencia() throws InterruptedException {
        realizarLogin();
        DadosTransferencia transferencia = new DadosTransferencia();
        DadosLogin login = new DadosLogin();

        browser.findElement(transferencia.getBotaoTransferencia()).click();
        browser.findElement(transferencia.getCampoNumeroConta()).sendKeys(String.valueOf(numeroDaConta));
        browser.findElement(transferencia.getCampoDigito()).sendKeys(String.valueOf(numeroDigito));
        browser.findElement(transferencia.getCampoValor()).sendKeys("250");
        browser.findElement(transferencia.getCampoDescricao()).sendKeys("Transferindo...");
        browser.findElement(transferencia.getBotaoTranferirAgora()).click();
        Thread.sleep(2000);
        browser.findElement(transferencia.getBotaoFechar()).click();
        Thread.sleep(2000);
        browser.findElement(transferencia.getBotaoVoltar()).click();
        Thread.sleep(2000);
        validarSaida();
        browser.findElement(login.getBotaoLogout()).click();

    }

    public void realizarLogin() throws InterruptedException {
        DadosLogin dadosLogin = new DadosLogin();
        browser.findElement(dadosLogin.getCampoEmail()).sendKeys("ron.weasley@gmail.com");
        browser.findElement(dadosLogin.getCampoSenha()).sendKeys("teste123");
        Thread.sleep(2000);
        browser.findElement(dadosLogin.getBotaoAvancar()).click();
    }

    public void realizarLogin2() throws InterruptedException {
        DadosLogin dadosLogin = new DadosLogin();
        browser.findElement(dadosLogin.getCampoEmail()).sendKeys("harry.potter@gmail.com");
        browser.findElement(dadosLogin.getCampoSenha()).sendKeys("123teste");
        browser.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Thread.sleep(2000);
        browser.findElement(dadosLogin.getBotaoAvancar()).click();
    }

    public void validarSaida() throws InterruptedException {
        DadosConta dados = new DadosConta();
        String saldo = browser.findElement(dados.getSaldoConta()).getText();
        Thread.sleep(2000);

        if (saldo.equals("R$ 750,00")){
            System.out.println("Saldo encontrado após realização da Transferência: " + saldo);

        }else{
            System.out.println("O valor da Transferência é diferente do esperado.");
        }

    }

    public void validarEntrada() throws InterruptedException {
        realizarLogin2();
        DadosConta dados = new DadosConta();
        DadosLogin logout = new DadosLogin();
        Thread.sleep(2000);
        String saldoEntrada = browser.findElement(dados.getSaldoConta()).getText();

        if (saldoEntrada.equals("R$ 1.250,00")){
            System.out.println("Saldo encontrado após recebimento da Transferência: " + saldoEntrada);

        }else{
            System.out.println("O valor da Transferência é diferente do esperado.");
        }

        browser.findElement(logout.getBotaoLogout()).click();
    }
}

