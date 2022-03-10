package com.learn.RestApi.RestApiAdvance.topic;

import com.learn.RestApi.RestApiAdvance.topic.Topic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TopicService {

    private static List<Topic> topics=new ArrayList<>();

    static {
        topics.add(new Topic(1,"Spring"));
        topics.add(new Topic(2,"Spring MVC"));
        topics.add(new Topic(3,"Spring BOOT"));
        topics.add(new Topic(4,"Java is Fum"));


    }

    public List<Topic> getAllTopics(){
        return topics;
    }
}
