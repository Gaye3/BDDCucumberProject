package com.qa.pages;

import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PostPage {
    private WebDriver driver;

//    ElementUtil element = new ElementUtil();

    private By sideNavBarNames = By.xpath("//div[@class='sidebar-nav-container']//li/a");
    private By createPostBtn = By.xpath("//button[@id='create-button']");
    private By postOption = By.xpath("//span[text()='Anonymous']/parent::label//input");
    private By postType = By.xpath("//div/button[text()='OPEN']");
    private By dropDownBtn = By.xpath("//span[@class='Select-arrow']");
    private By postGroup = By.xpath("//div[@class='Select-menu-outer']/div/div/div[text()='Arnaud only']");
    private By selectBtn = By.xpath("//div/button[text()='Select']");
    private By textArea = By.xpath("//div[@class='form-group']/textarea");
    private By publishPostBtn = By.xpath("//button[text()='Publish post']");
    private By newPostText = By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[1]/h3");
    private By multipleChoice = By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[2]/div/div[3]/div[1]/button");
    private By newPostSelect = By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[1]/h3");
    private By MulSelectBtn = By.xpath("//*[@id=\"react-select-2--value\"]");
    private By selectMulBtn = By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[2]/form/div[2]/div[2]/button");
    private By writePostTxt = By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[1]/h3");
    private By writeTxtBox = By.xpath("//*[@id=\"textAreaField\"]");
    private By optionOne = By.xpath("//*[@name=\"option1\"]");
    private By optionTwo = By.xpath("//*[@name=\"option2\"]");
    private By publishPostBtn2 = By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[2]/form/button");
    
    
    public void writePostQuestion(String q,String o1,String o2) throws InterruptedException {
    	Thread.sleep(5000);
    	driver.findElement(writeTxtBox).sendKeys(q);
    	driver.findElement(optionOne).sendKeys(o1);
    	driver.findElement(optionTwo).sendKeys(o2);
    	driver.findElement(publishPostBtn2).click();
    }
    
    public String getWritePostText() throws InterruptedException {
    	Thread.sleep(5000);
    	return driver.findElement(writePostTxt).getText();
    }
    
    public void selectMultipleBoxValues(String value) throws InterruptedException {
    	Thread.sleep(5000);
    	System.out.println("cliking on select drop down");
    	driver.findElement(By.xpath("//*[@id=\"modal-root-container\"]/div[3]/div/div/div/div[2]/form/div[2]/div[1]/div/div/div/span[3]")).click();
    	System.out.println("cliking on select drop down -- sucessfull");
    	Thread.sleep(5000);
    	driver.findElement(MulSelectBtn).sendKeys(value);
    	driver.findElement(MulSelectBtn).sendKeys(Keys.ENTER);
    	driver.findElement(selectMulBtn).click();
    }
    
    
    public String getNewPostText() throws InterruptedException {
    	Thread.sleep(5000);
    	return driver.findElement(newPostText).getText();
    }
    
    public void clickMultipleChoice() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.findElement(multipleChoice).click();
    }
    
    public String getNewSelectText() throws InterruptedException {
    	Thread.sleep(5000);
    	return driver.findElement(newPostSelect).getText();
    }
    
    
    
    public PostPage(WebDriver driver){
        this.driver = driver;

    }
    public String getPostPageTitle(){

        return driver.getTitle();
    }
    public int getSidePanelCount(){
       int countList =  driver.findElements(sideNavBarNames).size();
        System.out.println("Count List is: "+countList);
       return countList;
    }
    public List<String> getSidePanelList(){
        List<String> panelList = new ArrayList<String>();
        List<WebElement> panelHeaderList = driver.findElements(sideNavBarNames);
        for (WebElement e : panelHeaderList){
            String text = e.getText();
            System.out.println(text);
            panelList.add(text);
        }
        return panelList;
    }
    public void clickOnCreatePostBtn() throws InterruptedException{
    	Thread.sleep(5000);
        driver.findElement(createPostBtn).click();
    }
    public void creatingPostByOptions(){
        driver.findElement(postOption).click();
        driver.findElement(postType).click();
        driver.findElement(dropDownBtn).click();
        driver.findElement(postGroup).click();
        driver.findElement(selectBtn).click();


    }
    public void clickPublishBtn(){

        driver.findElement(publishPostBtn).click();
//        element.doClick(publishPostBtn);
    }


}
