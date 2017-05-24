package com.anton.instagram;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramFollowRequest;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;
import org.brunocvcunha.instagram4j.requests.payload.StatusResult;

public class Main {

    public static void main(String[] args) {
        try {
            Instagram4j instagram = Instagram4j.builder().username("user").password("password").build();
            instagram.setup();
            instagram.login();

            InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest("other_user"));
            InstagramGetUserFollowersResult followersRequest = instagram.sendRequest(new InstagramGetUserFollowersRequest(userResult.getUser().getPk()));
            System.out.println("ID for @github is " + userResult.getUser().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
