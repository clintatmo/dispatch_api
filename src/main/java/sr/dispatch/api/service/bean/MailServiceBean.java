package sr.dispatch.api.service.bean;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import sr.dispatch.api.service.MailService;

import java.io.StringWriter;

/**
 * Created by catmosoerodjo on 2/1/2017.
 */
public class MailServiceBean implements MailService {

    @Override
    public String generateMailContent(Object model) {

        VelocityEngine velocityEngine = new VelocityEngine();
        Template template = velocityEngine.getTemplate("template/SimpleEmailMessage.vm");
        VelocityContext context = new VelocityContext();
        context.put("message", "Hello");
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    }
}
