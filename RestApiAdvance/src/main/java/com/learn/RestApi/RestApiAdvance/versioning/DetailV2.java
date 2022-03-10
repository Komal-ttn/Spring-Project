package com.learn.RestApi.RestApiAdvance.versioning;

public class DetailV2 {

    private AdvanceDetails advanceDetails;
    public DetailV2() {
        super();
    }

    public DetailV2(AdvanceDetails advanceDetails) {
        super();
        this.advanceDetails = advanceDetails;
    }

    public AdvanceDetails getAdvanceDetails() {
        return advanceDetails;
    }

    public void setAdvanceDetails(AdvanceDetails advanceDetails) {
        this.advanceDetails = advanceDetails;
    }

}