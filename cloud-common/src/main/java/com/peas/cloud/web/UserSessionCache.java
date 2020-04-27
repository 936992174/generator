package com.peas.cloud.web;

import com.peas.cloud.cache.StringCache;
import org.springframework.stereotype.Component;

/**
 * Created by Benson on 2018/3/7.
 */
@Component
public class UserSessionCache extends StringCache {

    public String setUserSession(String userId, String sessionId) {
        if (userId == null || sessionId == null) {
            return null;
        }

        String tmp = get(userId);
        if (sessionId.equals(tmp)) {
            return null;
        }
        put(userId, sessionId);
        return tmp;
    }

    @Override
    public String getPrefix() {
        return "user:session";
    }

    @Override
    protected Integer getTimeout() {
        return 12 * RedisTime.HOURE;
    }

    @Override
    public void invalid(String key) {
        remove(key);
    }
}
