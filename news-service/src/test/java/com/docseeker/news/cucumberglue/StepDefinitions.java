package com.docseeker.news.cucumberglue;

import com.docseeker.news.api.NewsRecordController;
import com.docseeker.news.domain.model.entity.NewsRecord;
import com.docseeker.news.resource.CreateNewsRecordResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatusCode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private NewsRecordController newsRecordController;

    public StepDefinitions(NewsRecordController newsRecordController) {
        this.newsRecordController = newsRecordController;
    }

    @Given("the user is on the home page")
    public void userIsOnHomePage() {
        int saved = 0;
        for (int i = 0; i < 3; i++) {
            CreateNewsRecordResource resource = new CreateNewsRecordResource(
                    "News " + i, "News about health", "image.cloud.dev.com");
            newsRecordController.save(resource);
            saved += 1;
        }
        assertEquals(3, saved);
    }

    @When("the user clicks on the news button")
    public void userClicksNewsButton() {
        HttpStatusCode responseCode = newsRecordController.fetchAll().getStatusCode();
        assertEquals(200, responseCode.value());
    }

    @Then("the user is shown the latest news about health and fitness")
    public void UserIsShownLatestNews() {
        List<NewsRecord> news = newsRecordController.fetchAll().getBody();
        assertEquals(32, news.size());
    }
}
