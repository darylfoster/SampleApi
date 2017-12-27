/**
 *
 * Copyright (c) 2013 On Center Software, Inc - All Rights Reserved
 *
 * JaxRsActivator.java
 *
 */



package net.foster.sample.rest;

//~--- non-JDK imports --------------------------------------------------------

import io.swagger.jaxrs.config.BeanConfig;

//~--- JDK imports ------------------------------------------------------------

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//~--- classes ----------------------------------------------------------------

/**
 * Class description
 *
 *
 * @author         Daryl Foster
 */
@ApplicationPath ("/rest")
public class JaxRsActivator
        extends Application
{
    //~--- constructors -------------------------------------------------------

    /**
     * Constructs ...
     *
     */
    public JaxRsActivator ()
    {
        BeanConfig beanConfig = new BeanConfig ();

        beanConfig.setVersion ("1.0.0");
        beanConfig.setSchemes (new String[] {"https"});
        beanConfig.setHost ("localhost");
        beanConfig.setBasePath ("/Sample/rest");

        StringBuilder packageListBuilder = new StringBuilder ();

        packageListBuilder.append ("net.foster.sample.rest");
        beanConfig.setResourcePackage (packageListBuilder.toString ());
        beanConfig.setScan (true);
    }

    //~--- get methods --------------------------------------------------------

    @Override
    public Set<Class<?>> getClasses ()
    {
        Set<Class<?>> resources = new java.util.HashSet<> ();

        addRestResourceClasses (resources);
        addSwaggerResourceClasses (resources);

        return resources;
    }

    //~--- methods ------------------------------------------------------------

    private void addRestResourceClasses (Set<Class<?>> resources)
    {
        resources.add (net.foster.sample.rest.SampleResource.class);
    }

    private void addSwaggerResourceClasses (Set<Class<?>> resources)
    {
        resources.add (io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add (io.swagger.jaxrs.listing.SwaggerSerializers.class);
    }
}
