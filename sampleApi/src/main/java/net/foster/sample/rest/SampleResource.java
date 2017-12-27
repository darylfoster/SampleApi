/**
 * 
 * Copyright (c) 2013 On Center Software, Inc - All Rights Reserved
 *
 * SampleResource.java 
 * 
 */
 


package net.foster.sample.rest;

//~--- non-JDK imports --------------------------------------------------------

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.foster.sample.model.SampleModelEntity;

//~--- JDK imports ------------------------------------------------------------

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

//~--- classes ----------------------------------------------------------------

/**
 * Sample REST Endpoints
 *
 *
 * @author         Daryl Foster    
 */
@Api (tags = {"samples"})
@Path ("/samples")
@Stateless
@TransactionManagement (TransactionManagementType.BEAN)
public class SampleResource
{
    //~--- constructors -------------------------------------------------------

    /**
     * Constructs ...
     *
     */
    public SampleResource () {}

    //~--- methods ------------------------------------------------------------

    /**
     * Method description
     *
     *
     * @param sampleParameter
     * @param request
     *
     * @return
     */
    @ApiOperation (value = "Retrieve Sample Api Entities")
    @ApiResponses (value = {@ApiResponse (
        code              = 200,
        message           = "Sample Api Entities retrieved",
        response          = SampleApiEntity.class,
        responseContainer = "List"
    ) })
    @GET
    @Path ("/api/{sampleparameter}")
    @Produces (MediaType.APPLICATION_JSON)
    public Response returnApiSamples (@ApiParam (value = "sampleParameter")
    @PathParam ("sampleparameter") String sampleParameter, @Context Request request)
    {
        SampleApiEntity sample1 = new SampleApiEntity ();

        sample1.setDescription ("This is sample api entity one. " + sampleParameter);
        sample1.setLevel (1);
        sample1.setSampleApiEntityId (UUID.randomUUID ());
        sample1.setTime (new Timestamp (System.currentTimeMillis ()));

        SampleApiEntity sample2 = new SampleApiEntity ();

        sample2.setDescription ("This is sample api entity two. " + sampleParameter);
        sample2.setLevel (2);
        sample2.setSampleApiEntityId (UUID.randomUUID ());
        sample2.setTime (new Timestamp (System.currentTimeMillis ()));

        List<SampleApiEntity> samples = new ArrayList<> ();

        samples.add (sample1);
        samples.add (sample2);

        return Response.ok (samples).build ();
    }

    /**
     * Method description
     *
     *
     * @param sampleParameter
     * @param request
     *
     * @return
     */
    @ApiOperation (value = "Retrieve Sample Model Entities")
    @ApiResponses (value = {@ApiResponse (
        code              = 200,
        message           = "Sample Model Entities retrieved",
        response          = SampleModelEntity.class,
        responseContainer = "List"
    ) })
    @GET
    @Path ("/model/{sampleparameter}")
    @Produces (MediaType.APPLICATION_JSON)
    public Response returnModelSamples (@ApiParam (value = "sampleParameter")
    @PathParam ("sampleparameter") String sampleParameter, @Context Request request)
    {
        SampleModelEntity sample1 = new SampleModelEntity ();

        sample1.setDescription ("This is sample model entity one. " + sampleParameter);
        sample1.setLevel (1);
        sample1.setSampleModelEntityId (UUID.randomUUID ());
        sample1.setTime (new Timestamp (System.currentTimeMillis ()));

        SampleModelEntity sample2 = new SampleModelEntity ();

        sample2.setDescription ("This is sample model entity two. " + sampleParameter);
        sample2.setLevel (2);
        sample2.setSampleModelEntityId (UUID.randomUUID ());
        sample2.setTime (new Timestamp (System.currentTimeMillis ()));

        List<SampleModelEntity> samples = new ArrayList<> ();

        samples.add (sample1);
        samples.add (sample2);

        return Response.ok (samples).build ();
    }
}
