/*
 * Copyright 2014 Thomas Hoffmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xyz.abcapp.dotalife.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.TimeZone;

import xyz.abcapp.dotalife.BuildConfig;
import xyz.abcapp.dotalife.Database;

/**
 * Class to look for changes in the timezone setting and to adjust the database on a change
 */
public class TimeZoneListener extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        SharedPreferences prefs =
                context.getSharedPreferences("pedometer", Context.MODE_MULTI_PROCESS);
        TimeZone oldTimeZone =
                TimeZone.getTimeZone(prefs.getString("timezone", TimeZone.getDefault().getID()));
        TimeZone newTimeZone = TimeZone.getTimeZone(intent.getStringExtra("time-zone"));
        if (BuildConfig.DEBUG) {
            Logger.log("timezone changed: new: " + newTimeZone.getRawOffset() + " old: " +
                    oldTimeZone.getRawOffset());
            Logger.log("Today: " + Util.getToday());
        }
        Database db = Database.getInstance(context);
        db.timeZoneChanged(newTimeZone.getRawOffset() - oldTimeZone.getRawOffset());
        db.close();
        prefs.edit().putString("timezone", intent.getStringExtra("time-zone")).commit();
    }

}
