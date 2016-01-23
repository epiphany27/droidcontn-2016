package com.nilhcem.droidcontn.data.api;

import com.nilhcem.droidcontn.data.model.ScheduleDay;
import com.nilhcem.droidcontn.data.model.Speaker;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface DroidconService {

    @GET("schedule")
    Observable<List<ScheduleDay>> loadSchedule();

    @GET("speakers")
    Observable<List<Speaker>> loadSpeakers();
}
