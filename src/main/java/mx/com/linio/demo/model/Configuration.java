package mx.com.linio.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by macbookpro on 15/07/17.
 */
@Repository
@ConfigurationProperties("lineoconfiguration")
public class Configuration {

    private Map<Integer,String> configurations;

    private String joinMessage;

    private Integer minLimit;

    private Integer maxLimit;

    public Map<Integer, String> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Map<Integer, String> configurations) {
        this.configurations = configurations;
    }

    public String getJoinMessage() {
        return joinMessage;
    }

    public void setJoinMessage(String joinMessage) {
        this.joinMessage = joinMessage;
    }

    public Integer getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }

    public Integer getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Integer maxLimit) {
        this.maxLimit = maxLimit;
    }
}
