package StepDefn;

import Rest.Rest_Post_Hit;
import io.cucumber.java.en.*;


public class Post_hit_Sd extends Rest_Post_Hit {
    @Given("User has base URL")
    public void user_has_base_url() {
        //baseurl();
    }
    @When("User create post request")
    public void user_create_post_request() {
       Create_Post_Request("src/test/Test_Data/Post_Request.json");
    }

    @Then("User hits post request and Status code is {int}")
    public void user_hits_post_request_and_status_code_is(Integer int1) {
      hit_Post_request();
    }


}
