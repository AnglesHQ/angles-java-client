package com.github.angleshq.angles.listeners.log4j2;

import com.github.angleshq.angles.AnglesReporter;
import com.github.angleshq.angles.exceptions.AnglesPropertyNotGivenException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.io.Serializable;

import static com.github.angleshq.angles.listeners.AbstractAnglesListener.getAnglesPropertyFromSystem;

@Plugin(name = "AnglesLog4j2LogAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public class AnglesLog4j2LogAppender extends AbstractAppender {

    protected AnglesReporter anglesReporter;
    protected String runName;
    protected String team;
    protected String component;
    protected String environment;

    protected AnglesLog4j2LogAppender(String name, Filter filter, Layout<? extends Serializable> layout,
                                      boolean ignoreExceptions, Property[] properties)
                                        throws AnglesPropertyNotGivenException {
        super(name, filter, layout, ignoreExceptions, properties);
        anglesReporter = AnglesReporter.getInstance(getAnglesPropertyFromSystem("angles.url") + "/rest/api/v1.0/");
        runName = getAnglesPropertyFromSystem("angles.runName");
        team = getAnglesPropertyFromSystem("angles.team");
        component = getAnglesPropertyFromSystem("angles.component");
        environment = getAnglesPropertyFromSystem("angles.environment");
    }

    @PluginFactory
    public static AnglesLog4j2LogAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter) throws AnglesPropertyNotGivenException {
        return new AnglesLog4j2LogAppender(name, filter, null, true, null);
    }

    @Override
    public void append(LogEvent event) {
        Level logLevel = event.getLevel();
        switch(logLevel.toString()) {
            case "DEBUG":
                anglesReporter.debug(event.getMessage().getFormattedMessage());
                break;
            case "ERROR":
                anglesReporter.error(event.getMessage().getFormattedMessage());
                break;
            default:
                anglesReporter.info(event.getMessage().getFormattedMessage());
        }
    }
}
