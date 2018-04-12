package com.polytech.web;

import com.polytech.services.FeedService;
import com.polytech.services.PublicationService;
import com.polytech.services.Story;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedRestController {

    private FeedService feedService;
    private PublicationService publicationService;

    public FeedRestController(FeedService feedService) {
        this.feedService = feedService;
    }

    @RequestMapping(value = "/rest/feed", method = RequestMethod.GET)
    public List<Story> stories() {
        List<Story> stories = feedService.fetchAll();
        return  stories;
    }

    @RequestMapping(value = "/rest/feed", method = RequestMethod.POST)
    public Story stories(String content) {
        Story story = new Story(content);
        publicationService.share(story);
        return story;
    }
}
