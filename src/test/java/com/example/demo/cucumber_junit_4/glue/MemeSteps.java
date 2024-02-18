package com.example.demo.cucumber_junit_4.glue;

import com.example.demo.model.Meme;
import com.example.demo.repository.MemeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/***
 * @author : github.com/eigennspace
 * @since : Sat 17/02/2024 22:45
 * @Project : demo
 * @Created_by : IdeaU
 */
public class MemeSteps {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static final List<Meme> expectedMemes = new ArrayList<>();
    private static final List<Meme> actualMemes = new ArrayList<>();

    @Before
    public void setup() {
        memeRepository.deleteAll();
    }

    @Given("the following memes")
    public void theFollowingMemes(final List<Meme> memes) {
        expectedMemes.addAll(memes);
        memeRepository.saveAll(memes);
    }

    @When("the user requests all the memes")
    public void theUserRequestsAllTheMemes() throws Exception {
        String result = mockMvc.perform(get("/api/v1/memes"))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.length()").value(greaterThan(1)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        List<Meme> resultTransform = objectMapper.readValue(result, new TypeReference<List<Meme>>() {});
        actualMemes.addAll(resultTransform);
    }

    @Then("all the memes are returned")
    public void allTheMemesAreReturned() {
        validateMemes();
    }

    private void validateMemes() {
        assertEquals(expectedMemes.size(), actualMemes.size());
        IntStream.range(0, actualMemes.size())
                .forEach(i -> {
                    validateMeme(expectedMemes.get(i), actualMemes.get(i));
                    System.out.println(expectedMemes.get(i));
                    System.out.println(actualMemes.get(i));
                });
    }

    private void validateMeme(final Meme expected, final Meme actual) {
        assertEquals(expected, actual);
    }
}
