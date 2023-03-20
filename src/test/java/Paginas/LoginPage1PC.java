package Paginas;

import modulos.EnderecosWeb.URLDataFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1PC {
    private WebDriver navegador;

    public LoginPage1PC(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String verificarTitulo(){
        navegador.findElement(By.cssSelector("h1")).isDisplayed();
        return navegador.findElement(By.cssSelector("h1")).getText();
    }
    public String verificarSubTitulo(){
        navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > div > p")).isDisplayed();
        return navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > div > p")).getText();
    }

    public String verificarLabelEmail(){
        navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(1) > label")).isDisplayed();
        return navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(1) > label")).getText();
    }

    public LoginPage1PC verficarInputDigiteSeuEmail(String email){
        navegador.findElement(By.cssSelector("input[placeholder=\"Digite seu e-mail\"]")).click();
        navegador.findElement(By.cssSelector("input[placeholder=\"Digite seu e-mail\"]")).sendKeys(email);

        return this;
    }
    public String alertaEmailInvalido(){
        return navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(1) > span")).getText();
    }

    public String alertaErroEmailObrigatorio(){
        return navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(1) > span")).getText();
    }

    public String verificarLabelSenha(){
        navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(2) > label")).isDisplayed();
        return navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(2) > label")).getText();
    }

    public LoginPage1PC verficarInputDigiteSuaSenha(String senha){
        navegador.findElement(By.cssSelector("input[placeholder=\"Digite sua senha\"]")).click();
        navegador.findElement(By.cssSelector("input[placeholder=\"Digite sua senha\"]")).sendKeys(senha);

        return this;
    }

    public String alertaErroSenhaObrigatoria(){
        return navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div:nth-child(2) > span")).getText();
    }

    public LoginPage1PC submeterLoginPage(){
        navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > div > div.sc-ifp7m1-1.iIpzcA > form > div.button-container > button")).click();

        return this;
    }
    public EsqueciMinhaSenhaPage getEsqueciSenhaURL(){

        WebElement myLink = navegador.findElement(By.cssSelector(".esquecisenha[href=\"/saude/redefinicao-senha\"]"));
        Assertions.assertEquals(myLink.getText(), "Esqueci minha senha");
        Assertions.assertEquals(myLink.getAttribute("href"), URLDataFactory.urlTelaRedefinirSenha().getLinkTela());

        return new EsqueciMinhaSenhaPage(navegador);
    }


}
