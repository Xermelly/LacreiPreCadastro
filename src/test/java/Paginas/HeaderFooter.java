package Paginas;

import modulos.EnderecosWeb.URLDataFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HeaderFooter {
    private WebDriver navegador;

    public HeaderFooter(WebDriver navegador) {
        this.navegador = navegador;
    }

    public HeaderFooter verificarLogoHeader(){
        navegador.findElement(By.cssSelector("#header .logo a")).isDisplayed();
        navegador.findElement(By.cssSelector("#header .logo a")).click();

        return this;
    }

    public HeaderFooter verificarLogoFooter(){
        navegador.findElement(By.cssSelector("footer .logo a")).isDisplayed();
        navegador.findElement(By.cssSelector("footer .logo a")).click();

        return this;
    }

    public Boolean verificarLinksNavegaveisQuemSomos(){
        Boolean isElement;

        try{
            isElement = navegador.findElement(By.linkText("Quem somos")).isDisplayed();
        } catch (Exception e){
            isElement = false;
        }
        if (isElement){
            WebElement myLink = navegador.findElement(By.cssSelector("a[href=\"/quem-somos\"]"));
            Assertions.assertEquals(myLink.getText(), "Quem somos");
            Assertions.assertEquals(myLink.getAttribute("href"), URLDataFactory.urlTelaQuemSomos().getLinkTela());
            navegador.findElement(By.linkText("Quem somos")).click();
        }
        return isElement;
    }

    public Boolean verificarLinksNavegaveisAjuda(){

        Boolean isElement;

        try{
            isElement = navegador.findElement(By.linkText("Ajuda")).isDisplayed();
        } catch (Exception e){
            isElement = false;
        }
        if (isElement){
            WebElement myLink = navegador.findElement(By.cssSelector("a[href=\"/ajuda\"]"));
            Assertions.assertEquals(myLink.getText(), "Ajuda");
            Assertions.assertEquals(myLink.getAttribute("href"), URLDataFactory.urlTelaAjuda().getLinkTela());
            navegador.findElement(By.linkText("Ajuda")).click();
        }
        return isElement;
    }

    public Boolean verificarLinksNavegaveisEntrar(){

        Boolean isElement;

        try{
            isElement = navegador.findElement(By.linkText("Entrar")).isDisplayed();
        } catch (Exception e){
            isElement = false;
        }
        if (isElement){
            WebElement myLink = navegador.findElement(By.cssSelector("a[href=\"/entrar\"]"));
            Assertions.assertEquals(myLink.getText(), "Entrar");
            Assertions.assertEquals(myLink.getAttribute("href"), URLDataFactory.urlTela1PC().getLinkTela());
            navegador.findElement(By.linkText("Entrar")).click();
        }
        return isElement;
    }

    public Boolean verificarLinksNavegaveisLacreiSaude(){

        Boolean isElement;

        try{
            isElement = navegador.findElement(By.linkText("Lacrei Saúde")).isDisplayed();
        } catch (Exception e){
            isElement = false;
        }
        if (isElement){
            WebElement myLink = navegador.findElement(By.cssSelector("#gatsby-focus-wrapper > div > footer > div > div.menu > ul > li:nth-child(1) > a"));
            Assertions.assertEquals(myLink.getText(), "Lacrei Saúde");
            Assertions.assertEquals(myLink.getAttribute("href"), URLDataFactory.urlTela1PC().getLinkTela());
            navegador.findElement(By.linkText("Lacrei Saúde")).click();
        }
        return isElement;
    }

}
