package Parallel;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.pages.PostPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultiplePost{
	
	private PostPage postPage;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@When("user click on create a new post")
	public void user_click_on_create_a_new_post() throws InterruptedException {
		
		DriverFactory.getDriver().get("https://engage-web.betterworks.com/signin");
		postPage = loginPage.doLogin("hyphen_admin@acmetest.com","34067");
	    postPage.clickOnCreatePostBtn();
	}
	
	@Then("A Create new post -Select type pop up should open")
	public void a_create_new_post_select_type_pop_up_should_open() throws InterruptedException {
		System.out.println(postPage.getNewPostText());
	}
	
	@When("user click on mulitple choice")
	public void user_click_on_mulitple_choice() throws InterruptedException {
	    postPage.clickMultipleChoice();
	}
	
	@Then("Create new post -Select group pop up with drop down should open")
	public void create_new_post_select_group_pop_up_with_drop_down_should_open() throws InterruptedException {
	    System.out.println(postPage.getNewSelectText());
	}
	
	@When("User selects {string} and click on select")
	public void user_selects_and_click_on_select(String string) throws InterruptedException {
	   postPage.selectMultipleBoxValues(string);
	}
	
	@Then("Create new post -Write post should open")
	public void create_new_post_write_post_should_open() throws InterruptedException {
	    System.out.println(postPage.getWritePostText());
	}
	
	@When("user enters {string} {string} {string} and click on publish post")
	public void user_enters_and_click_on_publish_post(String string, String string2, String string3) throws InterruptedException {
	    postPage.writePostQuestion(string, string2, string3);
	}
	
	@Then("A new post with above data should be published")
	public void a_new_post_with_above_data_should_be_published() {
	    System.out.println("A new post with above data should be published");
	}


}
