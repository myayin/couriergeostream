package com.merve.couriergeostream.constants;

import lombok.experimental.UtilityClass;

public class Constants {
    @UtilityClass
    public class Kafka {

        public static final String DISTANCE_TRACKER_TOPIC_NAME = "distance_tracker";

        public static final String COURIER_TRACKER_CONSUMER_GROUP_ID = "COURIER_TRACKER_CONSUMER";

        public static final String ENTRANCE_TRACKER_CONSUMER_GROUP_ID = "ENTRANCE_TRACKER_CONSUMER_GROUP";
    }
}
