package com.rahulografy.zflickerphotos.util

object Constants {

    object Network {

        object Api {
            const val API_KEY = "4a4ceb10996287fc8cfb68adfd3a9b47"
            const val API_SECRET = "27e6e08ce7b13af5"

            const val API_BASE_URL = "https://www.flickr.com/services/rest/"

            const val API_RESPONSE_FORMAT = "json"

            const val PHOTO_BASE_URL = "https://live.staticflickr.com"
        }

        object Timeout {
            const val CONNECTION = 10L
            const val WRITE = 10L
            const val READ = 30L
        }

        object Cache {
            const val NAME = "zFlickerPhotosCache"
        }
    }
}
