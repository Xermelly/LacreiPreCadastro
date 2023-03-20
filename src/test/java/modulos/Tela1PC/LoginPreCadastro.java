package modulos.Tela1PC;

import Paginas.HeaderFooter;
import Paginas.LoginPage1PC;
import modulos.EnderecosWeb.EnderecoWeb;
import modulos.EnderecosWeb.URLDataFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@DisplayName("Testes Web da Tela 1PC Pre-Cadastro")
public class LoginPreCadastro {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver111\\chromedriver.exe");

        this.navegador = new ChromeDriver(options);
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        new EnderecoWeb();
        this.navegador.get(URLDataFactory.urlTela1PC().getLinkTela());
    }

    @Test
    @DisplayName("Verificar se a Logo é visível e clicável")
    public void testVerificarLogoPreCadastro(){
        new HeaderFooter(navegador)
                .verificarLogoFooter()
                .verificarLogoHeader();

    }

    @Test
    @DisplayName("Verificar se o link Quem somos é visível e clicável")
    public void testVerificarLinkQuemSomosPreCadastro(){
        Boolean isElement = new HeaderFooter(navegador)
                .verificarLinksNavegaveisQuemSomos();

        Assertions.assertEquals(true, isElement);
    }

    @Test
    @DisplayName("Verificar se o Link Ajuda é visível e clicável")
    public void testVerificarLinkAjudaPreCadastro(){
        Boolean isElement = new HeaderFooter(navegador)
                .verificarLinksNavegaveisAjuda();

        Assertions.assertEquals(true, isElement);
    }

    @Test
    @DisplayName("Verificar se o Botão Entrar é visível e clicável")
    public void testVerificarLinkEntrarPreCadastro(){
        Boolean isElement = new HeaderFooter(navegador)
                .verificarLinksNavegaveisEntrar();

        Assertions.assertEquals(true, isElement);
    }

    @Test
    @DisplayName("Verificar se o Título é visível e equivalente")
    public void testVerificarTituloPreCadastro(){
        String isElement = new LoginPage1PC(navegador)
                .verificarTitulo();

        Assertions.assertEquals("Boas-vindas à Lacrei Saúde", isElement);
    }

    @Test
    @DisplayName("Verificar se o SubTítulo é visível e equivalente")
    public void testVerificarSubTituloPreCadastro(){
        String isElement = new LoginPage1PC(navegador)
                .verificarSubTitulo();

        Assertions.assertEquals("Entre ou crie sua conta Lacrei", isElement);
    }

    @Test
    @DisplayName("Verificar se a Label E-mail é visível e equivalente")
    public void testVerificarLabelEmailPreCadastro(){
        String isElement = new LoginPage1PC(navegador)
                .verificarLabelEmail();

        Assertions.assertEquals("E-mail", isElement);
    }

    @Test
    @DisplayName("Verificar se o input Digite seu e-mail é visível e clicável")
    public void testVerificarInputDigiteSeuEmailPreCadastro(){
        String isAlert = new LoginPage1PC(navegador)
                .verficarInputDigiteSeuEmail("email.com.br")
                .submeterLoginPage()
                .alertaEmailInvalido();

        Assertions.assertEquals("Por favor, utilize um formato de e-mail válido. Por exemplo: email@dominio.com.br", isAlert);
    }

    @Test
    @DisplayName("Verificar se o input Digite seu e-mail é obrigatorio")
    public void testVerificarInputDigiteSeuEmailObrigatorioPreCadastro(){
        String isAlert = new LoginPage1PC(navegador)
                .verficarInputDigiteSeuEmail("")
                .submeterLoginPage()
                .alertaErroEmailObrigatorio();

        Assertions.assertEquals("Este campo é obrigatório!", isAlert);
    }

    @Test
    @DisplayName("Verificar se a Label Senha é visível e equivalente")
    public void testVerificarLabelSenhaPreCadastro(){
        String isElement = new LoginPage1PC(navegador)
                .verificarLabelSenha();

        Assertions.assertEquals("Senha", isElement);
    }

    @Test
    @DisplayName("Verificar se o input Digite sua senha é visível e clicável")
    public void testVerificarInputDigiteSuaSenhaPreCadastro(){
                new LoginPage1PC(navegador)
                    .verficarInputDigiteSuaSenha("Teste123");
    }

    @Test
    @DisplayName("Verificar se ao submeter formulario em branco o alerta de erro é exibido")
    public void testVerificarInputSubmeterFormEmBrancoPreCadastro(){
        String isAlert = new LoginPage1PC(navegador)
                .verficarInputDigiteSuaSenha("")
                .submeterLoginPage()
                .alertaErroSenhaObrigatoria();

        Assertions.assertEquals("Este campo é obrigatório!", isAlert);
    }

    @Test
    @DisplayName("Verificar se o Link Esqueci minha senha visível e clicável")
    public void testVerificarLinkEsqueciMinhaSenhaPreCadastro(){
        new LoginPage1PC(navegador)
                .getEsqueciSenhaURL();
    }

    @Test
    @DisplayName("Verificar se o Link Lacrei Saúde é visível e clicável")
    public void testverificarLinksNavegaveisLacreiSaude(){
        new HeaderFooter(navegador)
                .verificarLinksNavegaveisLacreiSaude();
    }

    @AfterEach
    public void afterEach(){
        this.navegador.quit();
    }
}
