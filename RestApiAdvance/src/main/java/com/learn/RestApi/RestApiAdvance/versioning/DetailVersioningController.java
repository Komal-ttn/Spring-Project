package com.learn.RestApi.RestApiAdvance.versioning;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailVersioningController {

    @GetMapping("v1/detail")
    public DetailV1 detailV1V1() {
        return new DetailV1("Komal Rawat","Delhi,India");
    }

    @GetMapping("v2/detail")
    public DetailV2 detailV2() {
        return new DetailV2(new AdvanceDetails(new Address("Rosza","Uk","India"),
                "Komal","Rawat"));
    }

    @GetMapping(value = "/detail/param", params = "version=1")
    public DetailV1 paramV1() {
        return new DetailV1("Komal Rawat","Delhi,India");
    }

    @GetMapping(value = "/detail/param", params = "version=2")
    public DetailV2 paramV2() {
        return new DetailV2(new AdvanceDetails(new Address("Rosza","Uk","India"),
                "Komal","Rawat"));
    }

    @GetMapping(value = "/detail/header", headers = "X-API-VERSION=1")
    public DetailV1 headerV1() {
        return new DetailV1("Komal Rawat","Delhi,India");
    }

    @GetMapping(value = "/detail/header", headers = "X-API-VERSION=2")
    public DetailV2 headerV2() {
        return new DetailV2(new AdvanceDetails(new Address("Rosza","Uk","India"),
                "Komal","Rawat"));
    }

    @GetMapping(value = "/detail/produces", produces = "application/detail.app-v1+json")
    public DetailV1 producesV1() {
        return new DetailV1("Komal Rawat","Delhi,India");
    }

    @GetMapping(value = "/detail/produces", produces = "application/detail.app-v2+json")
    public DetailV2 producesV2() {
        return new DetailV2(new AdvanceDetails(new Address("Rosza","Uk","India"),
                "Komal","Rawat"));
    }

}